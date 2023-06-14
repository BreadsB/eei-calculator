package com.breadsb.simpleapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EEICalculatorController {
    public TextField nominalefficiencyfield;
    public TextField biomasscoefficientfield;
    public TextField parameterF2Field;
    public Label eeitext;
    Calculations calculations = new Calculations();

    @FXML
    protected void onCalculateButtonClick() {
        double nominalEfficiencyValue = calculations.convertTextFieldToDouble(nominalefficiencyfield.getText());
        double biomassEfficientValue = calculations.convertTextFieldToDouble(biomasscoefficientfield.getText());
        double parameterF2Value = calculations.convertTextFieldToDouble(parameterF2Field.getText());

        double result = calculations.calculate_EEI(nominalEfficiencyValue, biomassEfficientValue, parameterF2Value);

        eeitext.setText(String.format("%.2f", result));
    }
}