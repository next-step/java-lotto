package study.step1.controller;

import study.step1.domain.Calculator;

public class StringAddCalculator {
    public int splitAndSum(String input) {
        if(isEmpty(input)) {
            return 0;
        }
        Calculator calculator = new Calculator(input);
        return calculator.sum();
    }

    private boolean isEmpty(String input) {
        if(input == null || input.trim().isEmpty()) {
            return true;
        }
        return false;
    }
}
