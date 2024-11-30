package com.assignment.assignment.controller;

import com.assignment.assignment.util.AlertDialogUtil;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MainFormController {
    @FXML
    private TableView<ObservableList<String>> tableView;
    @FXML
    private TextField columnIndexField;
    @FXML
    private Button showColumnButton;
    @FXML
    private ComboBox<String> numericColumnComboBox;
    @FXML
    private Label dateTimeLabel;

    private ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

    private ObservableList<ObservableList<Double>> numericData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        showColumnButton.setOnAction(this::showSelectedColumn);
    }

    public void addCSVFileOnAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            String fileName = file.getName();
            if (fileName.endsWith(".csv")) {
                AlertDialogUtil.showConfirmation("CSV File Selected Successfully");
                loadCSVFile(file);
            } else {
                AlertDialogUtil.showError("Invalid file selected. Please select a valid CSV file.");
            }
        } else {
            AlertDialogUtil.showWarning("File selection canceled by the user");

        }
    }


    private void loadCSVFile(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isFirstRow = true;
            tableView.getColumns().clear();
            data.clear();
            numericColumnComboBox.getItems().clear();
            numericData.clear(); // Reset numericData

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (isFirstRow) {
                    isFirstRow = false;
                    createColumns(fields);
                } else {
                    ObservableList<String> row = FXCollections.observableArrayList(Arrays.asList(fields));
                    data.add(row);
                    ObservableList<Double> numericRow = FXCollections.observableArrayList();
                    for (int i = 0; i < fields.length; i++) {
                        try {
                            numericRow.add(Double.parseDouble(fields[i])); // Try parsing each value as a Double
                        } catch (NumberFormatException e) {
                            numericRow.add(Double.NaN); // Add NaN if not a valid number
                        }
                    }
                    numericData.add(numericRow);
                }
            }

            tableView.setItems(data);
            identifyNumericColumns(); // Identify numeric columns after loading data

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
