package com.breadsb.simpleapp;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class EEICalculatorController {
    public TextField nominalEfficiencyField;
    public TextField biomassCoefficientField;
    public TextField parameterF2Field;
    public Label eeiLabel;
    public Label energeticEfficiencyClass;
    Calculations calculations = new Calculations();

    @FXML
    protected void onCalculateButtonClick() {
        try {
            double result = calculations.calculateEEIValueFromTextField(nominalEfficiencyField, biomassCoefficientField, parameterF2Field);
            eeiLabel.setText( String.format("%.2f", result) );
            EnergeticClass eec = calculations.checkEnergeticEfficiencyClass(result);
            changeStyleOfEnergeticEfficiencyClass(eec, eec.getColorCode());
        } catch (NumberFormatException | EnergeticClassException ece) {
            eeiLabel.setText("Wrong input value");
            createAndShowAlert();
        }
    }

    private void changeStyleOfEnergeticEfficiencyClass(EnergeticClass eec, String colour) {
        energeticEfficiencyClass.setText(eec.getEnergeticClass());
        energeticEfficiencyClass.getStyleClass().clear();
        energeticEfficiencyClass.setStyle("-fx-background-color: " + colour + "; -fx-text-fill: white;");
    }

    private void createAndShowAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("ERROR: Please check again input values!");
        alert.showAndWait();
    }


}