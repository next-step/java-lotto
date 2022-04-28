package calculator.controller;

import calculator.view.InputView;
import calculator.view.ResultView;
import calculator.service.StringCalculator;

public class StringCalculatorController {
    private static final String ERROR_MESSAGE_FORM = "[ERROR] %s \n--------------------------------------";

    public void start() {
        try {
            String input = InputView.inputString();
            ResultView.printResult(StringCalculator.splitStringAndCalculate(input));
        } catch (Exception e) {
            System.out.println(String.format(ERROR_MESSAGE_FORM, e.getMessage()));
            start();
        }
    }
}
