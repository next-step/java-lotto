
package dev.dahye.calculator.service;

import dev.dahye.calculator.domain.Calculator;

public class StringAddCalculator {
    private static final int RESULT_WHEN_NULL_OR_EMPTY = 0;

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return RESULT_WHEN_NULL_OR_EMPTY;
        }

        Calculator calculator = Calculator.setting(input);
        return calculator.sum();
    }
}
