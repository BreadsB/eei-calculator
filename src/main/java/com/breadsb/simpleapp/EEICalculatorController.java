package com.breadsb.simpleapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;

import java.io.IOException;

public class EEICalculatorController {
    public TextField nominalefficiencyfield;
    public TextField biomasscoefficientfield;
    public TextField parameterF2Field;
    public Label eeitext;
    public Label energeticEfficiencyClass;
    Calculations calculations = new Calculations();

    @FXML
    protected void onCalculateButtonClick() {
        try {
            double nominalEfficiencyValue = calculations.check_ifTextFieldNotEmpty_returnCommaConvertion(nominalefficiencyfield);
            double biomassEfficientValue = calculations.check_ifTextFieldNotEmpty_returnCommaConvertion(biomasscoefficientfield);
            double parameterF2Value = calculations.check_ifTextFieldNotEmpty_returnCommaConvertion(parameterF2Field);

            double result = calculations.calculate_EEI(nominalEfficiencyValue, biomassEfficientValue, parameterF2Value);
            eeitext.setText(String.format("%.2f", result));
            String eec = calculations.checkEnergeticEfficiencyClass(result);
            energeticEfficiencyClass.setText(eec);
            changeStyleOfEnergeticEfficiencyClass();
        } catch (NumberFormatException e) {
            eeitext.setText("Wrong input value");
            System.out.println(e.getMessage());
        }
    }

    private void changeStyleOfEnergeticEfficiencyClass() {
        energeticEfficiencyClass.getStyleClass().add("-fx-border-color: #73ff00");
        energeticEfficiencyClass.getStyleClass().add("-fx-border-width: 5px");
        energeticEfficiencyClass.getStyleClass().add("-fx-border-radius: 5px");
        energeticEfficiencyClass.getStyleClass().add("-fx-text-fill: #73ff00");
    }
}