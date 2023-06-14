package com.breadsb.simpleapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class EEICalculatorController {
    public TextField nominalefficiencyfield;
    public TextField biomasscoefficientfield;
    public TextField parameterF2Field;
    public Label eeitext;
    Calculations calculations = new Calculations();

    @FXML
    protected void onCalculateButtonClick() {
        try {
            double nominalEfficiencyValue = calculations.check_ifTextFieldNotEmpty_returnCommaConvertion(nominalefficiencyfield);
            double biomassEfficientValue = calculations.check_ifTextFieldNotEmpty_returnCommaConvertion(biomasscoefficientfield);
            double parameterF2Value = calculations.check_ifTextFieldNotEmpty_returnCommaConvertion(parameterF2Field);

            double result = calculations.calculate_EEI(nominalEfficiencyValue, biomassEfficientValue, parameterF2Value);
            eeitext.setText(String.format("%.2f", result));
        } catch (NumberFormatException e) {
            eeitext.setText("Wrong input value");
            System.out.println(e.getMessage());
        }
    }
}