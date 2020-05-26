
package dev.dahye.calculator.service;

import dev.dahye.calculator.domain.Calculator;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        Calculator calculator = Calculator.setting(input);
        return calculator.sum();
    }
}
