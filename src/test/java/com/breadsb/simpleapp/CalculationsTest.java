package com.breadsb.simpleapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculationsTest {

    static Calculations calculations;

    @BeforeAll
    static void setup() {
        calculations = new Calculations();
    }

    @Test
    @DisplayName("Calculating EEI parameter")
    void givenAllParameters_whenCalculating_thenReturnEEI() {
//        GIVEN
        double nominalEfficiency = 81.3;
        double biomassCoefficient = 1.45;
        double parameter_f2 = 0;
//        WHEN
        double eei = calculations.calculate_EEI(nominalEfficiency, biomassCoefficient, parameter_f2);
//        THEN
        Assertions.assertEquals(106.10, eei, 0.01);
    }

    @Test
    @DisplayName("Convert Comma to Dot")
    void givenString_whenConvertCommaToDot_thenReturnString() {
//        GIVEN
        String given = "1,27";
//        WHEN
        String result = calculations.convertCommaToDot(given);
//        THEN
        Assertions.assertEquals("1.27", result);
    }

    @Test
    @DisplayName("Convert Textfield to double")
    void givenString_whenConvertToDouble_thenReturnDouble() {
//        GIVEN
        String init = "81,3";
//        WHEN
        double converted = calculations.convertTextFieldToDouble(init);
//        THEN
        Assertions.assertEquals(81.3, converted);
    }

    @Test
    @DisplayName("Check energetic efficiency class when EEI Parameter is given")
    void givenEEIParameter_whenCheckEnergeticEfficiencyClass_thenReturnEnergeticClass() {
//        GIVEN
        double eeiParameter = 100.0;
//        WHEN
        EnergeticClass result = calculations.checkEnergeticEfficiencyClass(eeiParameter);
        EnergeticClass expected = new EnergeticClass("A", Color.A_CLASS_COLOR);
//        THEN
        Assertions.assertEquals("A", result.getEnergeticClass());
        Assertions.assertEquals(Color.A_CLASS_COLOR, result.getColor());
        Assertions.assertEquals(result, expected);
    }
}