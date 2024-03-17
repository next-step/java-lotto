package model;

import java.util.List;

public class Calculation {
    private static final List<String> OPERATORS = List.of("+", "-", "*", "/");

    public static int plus(int firstInput, int secondInput) {
        return firstInput + secondInput;
    }

    public static int minus(int firstInput, int secondInput) {
        return firstInput - secondInput;
    }

    public static int multiple(int firstInput, int secondInput) {
        return firstInput * secondInput;
    }

    public static int divide(int firstInput, int secondInput) {
        return firstInput / secondInput;
    }
}
