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
}
