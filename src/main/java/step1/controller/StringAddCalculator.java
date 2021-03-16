package step1.controller;

import step1.service.Calculator;

public class StringAddCalculator {
    private Calculator calculator;

    public int splitAndSum(String inputText) {
        calculator = new Calculator(inputText);

        return calculator.sum();
    }
}
