package com.breadsb.simpleapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;

class CalculationsTest {

    static Calculations calculations;

    @BeforeAll
    static void setup() {
        calculations = new Calculations();
    }

    @Test
    @DisplayName("Calculating EEI parameter")
    void givenAllParameters_whenCalculating_thenReturnEEI() {
        double nominalEfficiency = 81.3;
        double biomassCoefficient = 1.45;
        double parameter_f2 = 0;

        double eei = calculations.calculate_EEI(nominalEfficiency, biomassCoefficient, parameter_f2);
        System.out.println(eei);

        Assertions.assertEquals(106.10, eei, 0.01);
    }
}