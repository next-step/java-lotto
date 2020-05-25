package com.cheolhyeonpark.calculator.domain;

import java.util.Arrays;

public class Expression {

    private final String[] numbers;

    public Expression(String[] numbers) {
        this.numbers = numbers;
    }

    public int getSum() {
        validate();
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
    }

    private void validate() {
        Arrays.stream(numbers).forEach(this::checkNumber);
    }

    private void checkNumber(String number) {
        if (isNegativeNumber(number)) {
            throw new RuntimeException("There is negative number in your input.");
        }
    }

    private boolean isNegativeNumber(String number) {
        return getIntegerNumber(number) < 0;
    }

    private int getIntegerNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Non numeric input error.");
        }
    }
}
