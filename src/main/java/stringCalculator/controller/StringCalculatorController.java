package stringCalculator.controller;

import stringCalculator.domain.StringCalculator;

public class StringCalculatorController {
    public int calculate(StringCalculator calculator) {
        return calculator.add();
    }
}
