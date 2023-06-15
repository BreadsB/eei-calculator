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
            return new EnergeticClass("G", Color.G_CLASS_COLOR);
        } else if (62.0 > EEI_Value) {
            return new EnergeticClass("F", Color.F_CLASS_COLOR);
        } else if (72.0 > EEI_Value) {
            return new EnergeticClass("E", Color.E_CLASS_COLOR);
        } else if (77.0 > EEI_Value) {
            return new EnergeticClass("D", Color.D_CLASS_COLOR);
        } else if (82.0 > EEI_Value) {
            return new EnergeticClass("C", Color.C_CLASS_COLOR);
        } else if (88.0 > EEI_Value) {
            return new EnergeticClass("B", Color.B_CLASS_COLOR);
        } else if (107.0 > EEI_Value) {
            return new EnergeticClass("A", Color.A_CLASS_COLOR);
        } else if (130.0 > EEI_Value) {
            return new EnergeticClass("A+", Color.A_PLUS_CLASS_COLOR);
        } else if (EEI_Value > 130.0) {
            return new EnergeticClass("A++", Color.A_2PLUS_CLASS_COLOR);
        } else {
            throw new EnergeticClassException();
        }
    }
}
