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
            EnergeticClass eec = calculations.checkEnergeticEfficiencyClass(result);
            energeticEfficiencyClass.setText(eec.getEnergeticClass());
            changeStyleOfEnergeticEfficiencyClass(eec.getColour(), 5);
        } catch (NumberFormatException | EnergeticClassException e) {
            eeitext.setText("Wrong input value");
            System.out.println("Error at: " + e.getCause());
        }
    }

    private void changeStyleOfEnergeticEfficiencyClass(String colour, int pixels) {
        energeticEfficiencyClass.getStyleClass().clear();
        energeticEfficiencyClass.setStyle("-fx-background-color: " + colour + ";\n" +
                "-fx-text-fill: white;");
    }
}