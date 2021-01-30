package stringCalculator.controller;

import stringCalculator.domain.StringCalculator;
import stringCalculator.view.InputHandler;
import stringCalculator.view.OutputHandler;

public class StringCalculatorController {

    private InputHandler inputHandler = new InputHandler();
    private OutputHandler outputHandler = new OutputHandler();
    private StringCalculator calculator;

    public void requestInput() {
        calculator = new StringCalculator(inputHandler.requestUserInput());
        try {
            calculator.validatePositiveNum();
        } catch (RuntimeException e) {
            outputHandler.printErrorNegativeNum();
            requestInput();
        }
    }

    public void calculate() {
        outputHandler.printResult(calculator.add());
    }
}
