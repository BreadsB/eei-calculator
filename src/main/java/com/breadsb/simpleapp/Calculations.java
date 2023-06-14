package com.breadsb.simpleapp;

public class Calculations {

    public int calculate_EEI(double sprawnoscNominalna, double wspolczynnikBiomasy, double parametrF2) {
        return (int) ((sprawnoscNominalna * wspolczynnikBiomasy)
                - ( 0.1*( sprawnoscNominalna*wspolczynnikBiomasy ) )
                + parametrF2);
    }
}
