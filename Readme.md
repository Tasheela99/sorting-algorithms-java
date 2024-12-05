# Sorting Algorithm Performance Evaluator Application

## Prerequisites

Before running this application, ensure you have the following installed:

- Java Development Kit (JDK) 11 or 17
- JavaFX SDK
- An Integrated Development Environment (IDE) like IntelliJ IDEA or Eclipse

## Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/Tasheela99/sorting-algorithms-java.git
cd [your-project-directory]
```

### 2. Configure JavaFX in Your IDE

#### IntelliJ IDEA
1. Open the project in IntelliJ IDEA
2. Ensure JavaFX SDK is configured in Project Structure
3. Add VM options for JavaFX:
   ```
   --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml
   ```

#### Eclipse
1. Install e(fx)clipse plugin
2. Right-click project > Properties > Java Build Path
3. Add JavaFX libraries to modulepath
4. Add VM arguments similar to IntelliJ

### 3. Running the Application

#### From IDE
- Locate `AppInitializer` class
- Right-click and select "Run"

#### From Command Line
```bash
# Compile the project
javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml [source files]

# Run the application
java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml com.assignment.programming3assignment.AppInitializer
```

## Troubleshooting

- Ensure all JavaFX dependencies are correctly added
- Verify the path to `MainForm.fxml` is correct
- Check that all required modules are included in VM options

## Dependencies
- JavaFX SDK
- Java 11+

## Project Structure
```
src/
    main/
    └── java/
        └── com/
            └── assignment/
                └── programming3assignment/
                    └── algorithms/
                        └── HeapSort.java
                        └── InsertionSort.java
                        └── MergeSort.java
                        └── QuickSort.java
                        └── ShellSort.java
                        └── SortingAlogorithm.java
                    └── controllers/
                        └── MainFormController.java
                        └── AnalysisScreenController.java
                    └── util/
                        └── AlertDialogUtil.java
                        └── ChartUtil.java
                    └── AppInitializer.java
                                      
        resources/
        └── com/
            └── assignment/
                └── programming3assignment/
                   ├── AnalysisScreen.fxml
                   └── MainForm.fxml
```

