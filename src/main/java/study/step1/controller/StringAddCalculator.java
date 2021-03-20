package study.step1.controller;

import study.step1.domain.Calculator;
import study.step1.validator.InputValidator;

public class StringAddCalculator {
    public int splitAndSum(String input) {
        if(!InputValidator.valid(input)) {
            return 0;
        }
        Calculator calculator = new Calculator(input);
        return calculator.sum();
    }
}
