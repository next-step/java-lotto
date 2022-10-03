package calculator.controller;

import calculator.view.InputView;
import calculator.view.ResultView;
import calculator.service.Calculator;

public class CalculatorControlller {
    public void start() {
        int result = Calculator.calculate(InputView.getUserInput());

        ResultView.printResult(result);
    }
}
