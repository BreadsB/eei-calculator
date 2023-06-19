package com.breadsb.simpleapp;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EEICalculatorController {
    public TextField nominalEfficiencyField;
    public TextField biomassCoefficientField;
    public TextField parameterF2Field;
    public Label eeiLabel;
    public Label energeticEfficiencyClass;
    public Button generatePDFButton;
    public Label productNameField;
    Calculations calculations = new Calculations();
    private boolean isEEICalculated = false;

    @FXML
    protected void onCalculateButtonClick() {
        try {
            double result = calculations.calculateEEIValueFromTextField(nominalEfficiencyField, biomassCoefficientField, parameterF2Field);
            eeiLabel.setText( String.format("%.2f", result) );
            EnergeticClass eec = calculations.checkEnergeticEfficiencyClass(result);
            changeStyleOfEnergeticEfficiencyClass(eec, eec.getColorCode());
            enablePDFButton();
        } catch (NumberFormatException | EnergeticClassException ece) {
            eeiLabel.setText("Wrong input value");
            createAndShowAlert("Input values must be numeric and not empty!\n" +
                    "Please fill proper values in fields");
        }
    }

    private void enablePDFButton() {
        generatePDFButton.setDisable(false);
    }

    private void changeStyleOfEnergeticEfficiencyClass(EnergeticClass eec, String colour) {
        energeticEfficiencyClass.setText(eec.getEnergeticClass());
        energeticEfficiencyClass.getStyleClass().clear();
        energeticEfficiencyClass.setStyle("-fx-background-color: " + colour + "; -fx-text-fill: white;");
    }

    private void createAndShowAlert(String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(text);
        alert.showAndWait();
    }

    private void onGeneratePDFButtonClick() {
        if(!productNameField.getText().isBlank()) {
            generatePDF();
        } else {
            createAndShowAlert("Product name is empty. Please fill field");
        }
//        Generate PDF
    }

    private void generatePDF() {
        LocalDateTime ldt = LocalDateTime.now();

    }
}