package model;

import java.util.List;

public class Calculate {
    private static final List<String> OPERATORS = List.of("+", "-", "*", "/");

    public int plus(int firstInput, int secondInput) {
        return firstInput + secondInput;
    }

    public int minus(int firstInput, int secondInput) {
        return firstInput - secondInput;
    }

    public int multiple(int firstInput, int secondInput) {
        return firstInput * secondInput;
    }

    public int divide(int firstInput, int secondInput) {
        return firstInput / secondInput;
    }
}
