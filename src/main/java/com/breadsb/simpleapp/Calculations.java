package com.breadsb.simpleapp;

import javafx.scene.control.TextField;

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

    public EnergeticClass checkEnergeticEfficiencyClass(double EEI_Value) {
        if(42.0 > EEI_Value) {
            return new EnergeticClass("G", "#AE0000");
        } else if (62.0 > EEI_Value) {
            return new EnergeticClass("F", "#C80000");
        } else if (72.0 > EEI_Value) {
            return new EnergeticClass("E", "#E00000");
        } else if (77.0 > EEI_Value) {
            return new EnergeticClass("D", "#FE0000");
        } else if (82.0 > EEI_Value) {
            return new EnergeticClass("C", "#FF7D01");
        } else if (88.0 > EEI_Value) {
            return new EnergeticClass("B", "#FECD44");
        } else if (107.0 > EEI_Value) {
            return new EnergeticClass("A", "#FFFF4D");
        } else if (130.0 > EEI_Value) {
            return new EnergeticClass("A+", "#A9C800");
        } else if (EEI_Value > 130.0) {
            return new EnergeticClass("A++", "#00AA01");
        } else {
            throw new EnergeticClassException();
        }
    }
}
