package com.breadsb.eeicalculator;

import java.util.Objects;

public class EnergeticClass {

    private final String energeticClass;
    private final Color color;
    private final String colorCode;

    public EnergeticClass(String energeticClass, Color color) {
        this.energeticClass = energeticClass;
        this.color = color;
        colorCode = setColorCode(color);
    }

    public String getEnergeticClass() {
        return energeticClass;
    }

    public String getColorCode() {
        return this.colorCode;
    }

    public Color getColor() {
        return color;
    }

    private String setColorCode(Color color) {
        return switch (this.color) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnergeticClass that = (EnergeticClass) o;
        return Objects.equals(energeticClass, that.energeticClass) && color == that.color && Objects.equals(colorCode, that.colorCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(energeticClass, color, colorCode);
    }
}
