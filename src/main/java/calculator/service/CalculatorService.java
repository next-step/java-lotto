package calculator.service;

import calculator.domain.Input;
import calculator.domain.Operand;
import calculator.domain.StringCalculator;
import calculator.dto.CalculationResult;

public class CalculatorService {
    private final StringCalculator stringCalculator;

    public CalculatorService(final StringCalculator stringCalculator) {
        this.stringCalculator = stringCalculator;
    }

    public CalculationResult calculate(final Input input) {
        Operand result = stringCalculator.calculate(input.split());
        return result.toCalculationResult();
    }
}
