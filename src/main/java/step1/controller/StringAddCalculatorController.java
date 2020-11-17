package step1.controller;

import step1.util.Util;

import java.util.Arrays;

public class StringAddCalculatorController {
    private static final String NOT_NUMBER_REGEX = "[^0-9]";
    private static final String NUMBER_REGEX = "^[0-9]{1,100}$";
    private final String expression;
    private int sum = 0;

    private static final Util util = new Util();

    public StringAddCalculatorController(String expression) {
        this.expression = expression;
        splitAndSum();
    }

    public static StringAddCalculatorController of(String expression) {
        util.numberValid(expression);
        util.isNegative(expression);
        return new StringAddCalculatorController(expression);
    }

    private void splitAndSum() {
        String[] values = this.expression.split(NOT_NUMBER_REGEX);
        Arrays.stream(values)
                .forEach(this::sumOfNumber);
    }

    private void sumOfNumber(String value) {
        if (isNumeric(value)) {
            this.sum += Integer.parseInt(value);
        }
    }

    private boolean isNumeric(String value) {
        return value.matches(NUMBER_REGEX);
    }

    public int getSum() {
        return this.sum;
    }
}
