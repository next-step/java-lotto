package study.calculator.controller;

import study.calculator.domain.StringAddition;
import study.calculator.view.InputView;
import study.calculator.view.ResultView;

public class CalculatorController {
    private CalculatorController() {
    }

    public static void run() {
        String text = InputView.getInput();
        int result = StringAddition.splitAndSum(text);
        ResultView.displayResult(result);
    }
}
