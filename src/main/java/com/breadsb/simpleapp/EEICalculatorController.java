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
        // take input values and convert , with .
        String nominalEfficiencyValue = nominalefficiencyfield.getText();
        String biomassCoefficientValue = biomasscoefficientfield.getText();
        String parameterF2Value = parameterF2Field.getText();

        String nominalEfficiencyValueConverted = nominalEfficiencyValue.replace(",", ".");
        String biomassCoefficientValueConverted = biomassCoefficientValue.replace(",", ".");
        String parameterF2ValueConverted = parameterF2Value.replace(",", ".");

        // take input values and calculate eei
        double nominalEfficiencyValue2 = Double.parseDouble(nominalEfficiencyValueConverted);
        double biomassEfficientValue2 = Double.parseDouble(biomassCoefficientValueConverted);
        double parameterF2Value2 = Double.parseDouble(parameterF2ValueConverted);

        System.out.println(nominalEfficiencyValue2 + " " + biomassEfficientValue2 + " " + parameterF2Value2);

        double result = calculations.calculate_EEI(nominalEfficiencyValue2, biomassEfficientValue2, parameterF2Value2);

        eeitext.setText(String.format("%.2f", result));
        System.out.println(result);
    }
}