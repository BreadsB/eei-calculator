package com.breadsb.simpleapp;

import javafx.scene.control.TextField;

import java.io.IOException;

public class Calculations {

    public String convertCommaToDot(String text) {
        return text.replace(",", ".");
    }

    public double convertTextFieldToDouble(String textField) {
        String converted = convertCommaToDot(textField);
        return Double.parseDouble(converted);
    }

    public double calculate_EEI(double sprawnoscNominalna, double wspolczynnikBiomasy, double parametrF2) {
        return ((sprawnoscNominalna * wspolczynnikBiomasy)
                - ( 0.1*( sprawnoscNominalna*wspolczynnikBiomasy ) )
                + parametrF2);
    }

    public double check_ifTextFieldNotEmpty_returnCommaConvertion(TextField textField) throws NumberFormatException {
        if (textField.getText().isBlank() || textField.getText().matches("[[:alpha:]]+")) {
            throw new NumberFormatException();
        }
        return convertTextFieldToDouble(textField.getText());
    }

    public String checkEnergeticEfficiencyClass(double EEI_Value) {
        if(42.0 > EEI_Value) {
            return "G";
        } else if (62.0 > EEI_Value) {
            return "F";
        } else if (72.0 > EEI_Value) {
            return "E";
        } else if (77.0 > EEI_Value) {
            return "D";
        } else if (82.0 > EEI_Value) {
            return "C";
        } else if (88.0 > EEI_Value) {
            return "B";
        } else if (107.0 > EEI_Value) {
            return "A";
        } else if (130.0 > EEI_Value) {
            return "A+";
        } else if (EEI_Value > 130.0) {
            return "A++";
        } else {
            return "No grade found, check all input values";
        }
    }
}
