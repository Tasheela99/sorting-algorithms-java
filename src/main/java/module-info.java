module com.assignment.programming3assignment {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.assignment.programming3assignment to javafx.fxml;
    exports com.assignment.programming3assignment;
    exports com.assignment.programming3assignment.controllers;
    opens com.assignment.programming3assignment.controllers to javafx.fxml;
}