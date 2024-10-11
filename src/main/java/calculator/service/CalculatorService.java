package calculator.service;

import calculator.domain.Input;
import calculator.domain.StringCalculator;

public class CalculatorService {
    private final StringCalculator stringCalculator;

    public CalculatorService(final StringCalculator stringCalculator) {
        this.stringCalculator = stringCalculator;
    }

    public int calculate(final Input input) {
        return stringCalculator.calculate(input.split());
    }
}
