package edu.nextstep.calculator.model;

public class Number {
    private final int value;

    Number(int value) {
        isNegative(value);
        this.value = value;
    }

    private void isNegative(int value) {
        if (value < 0) {
            throw new RuntimeException("Negative not permitted");
        }
    }
}
