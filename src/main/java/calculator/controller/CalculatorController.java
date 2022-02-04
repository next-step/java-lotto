package calculator.controller;

import calculator.domain.StringCalculator;
import calculator.view.InputView;

public class CalculatorController {

    private static final int DEFAULT_VALUE = 0;

    private final String userInput;
    private int resultValue;

    public CalculatorController() {
        userInput = InputView.getUserInput();
        resultValue = DEFAULT_VALUE;
    }

    public void start() {
        resultValue = StringCalculator.calculate(userInput);
    }

    public int getResultValue() {
        return this.resultValue;
    }
}
