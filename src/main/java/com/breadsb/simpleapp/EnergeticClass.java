package com.breadsb.simpleapp;

public class EnergeticClass {

    private final String energeticClass;
    private final Color color;
    private String colorCode;

    public EnergeticClass(String energeticClass, Color color) {
        this.energeticClass = energeticClass;
        this.color = color;
    }

    public String getEnergeticClass() {
        return energeticClass;
    }

    public String getColorCode() {
        return switch (color) {
            case G_CLASS_COLOR -> "#AE0000";
            case F_CLASS_COLOR -> "#C80000";
            case E_CLASS_COLOR -> "#E00000";
            case D_CLASS_COLOR -> "#FE0000";
            case C_CLASS_COLOR -> "#FF7D01";
            case B_CLASS_COLOR -> "#FECD44";
            case A_CLASS_COLOR -> "#FFFF4D";
            case A_PLUS_CLASS_COLOR -> "#A9C800";
            case A_2PLUS_CLASS_COLOR -> "#00AA01";
        };
    }
}
