package calculator.controller;

import calculator.domain.StringCalculator;
import calculator.view.InputView;

public class CalculatorController {

    private static final int DEFAULT_VALUE = 0;
    private final String userInput;
    private final StringCalculator stringCalculator;

    private int resultValue;

    public CalculatorController() {
        userInput = InputView.getUserInput();
        stringCalculator = new StringCalculator();
        resultValue = DEFAULT_VALUE;
    }

    public void start() {
        resultValue = stringCalculator.add(userInput);
    }

    public int getResultValue() {
        return this.resultValue;
    }
}
