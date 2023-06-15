package com.breadsb.simpleapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
//            One method that takes only fields and returns directly result as double
            eeitext.setText(String.format("%.2f", result));

            EnergeticClass eec = calculations.checkEnergeticEfficiencyClass(result);
            changeStyleOfEnergeticEfficiencyClass(eec, eec.getColorCode());

        } catch (NumberFormatException | EnergeticClassException e) {
            eeitext.setText("Wrong input value");
            System.out.println("Error at: " + e.getCause());
        }
    }

    private void changeStyleOfEnergeticEfficiencyClass(EnergeticClass eec, String colour) {
        energeticEfficiencyClass.setText(eec.getEnergeticClass());
        energeticEfficiencyClass.getStyleClass().clear();
        energeticEfficiencyClass.setStyle("-fx-background-color: " + colour + "; -fx-text-fill: white;");
    }
}