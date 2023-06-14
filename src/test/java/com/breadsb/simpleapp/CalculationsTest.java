package com.breadsb.simpleapp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculationsTest {

    static Calculations calculations;

    @BeforeAll
    static void setup() {
        calculations = new Calculations();
    }

    @Test
    @DisplayName("")
    void givenAllParameters_whenCalculating_thenReturnEEI() {
        double sprawnosc_nominalna = 81.3;
        double wspolczynnik_biomasy = 1.45;
        double parameter_f2 = 0;

        int result = calculations.calculate_EEI(sprawnosc_nominalna, wspolczynnik_biomasy, parameter_f2);
    }
}