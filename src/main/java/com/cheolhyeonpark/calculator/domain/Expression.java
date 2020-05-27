package com.cheolhyeonpark.calculator.domain;

import java.util.Arrays;

public class Expression {

    private final String[] numbers;

    public Expression(String[] numbers) {
        this.numbers = numbers;
    }

    public int getSum() {
        return Arrays.stream(numbers).mapToInt(this::getNumber).sum();
    }

    private int getNumber(String input) {
        int number = Integer.parseInt(input);
        if (number < 0) {
            throw new RuntimeException("There is negative number in your input.");
        }
        return number;
    }

    /*
    public int getSumUsingOneMethod() {
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).reduce(0, (sum, number) -> {
            if (number < 0) {
                throw new RuntimeException("There is negative number in your input.");
            }
            return sum + number;
        });
    }
    */
}
