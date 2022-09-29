package stringcalculator.domain;

import stringcalculator.domain.calculator.*;

public class Operator {
    private static final String PLUS = "+";
    private static final String SUBTRACT = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    private Operator() {

    }

    public static Calculator get(String value) {

        if (PLUS.equals(value)) {
            return new Plus();
        }
        if (SUBTRACT.equals(value)) {
            return new Subtract();
        }
        if (MULTIPLY.equals(value)) {
            return new Multiply();
        }
        if (DIVIDE.equals(value)) {
            return new Divide();
        }
        throw new IllegalArgumentException();

    }


}
