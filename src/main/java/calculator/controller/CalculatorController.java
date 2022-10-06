package calculator.controller;

import calculator.view.InputView;
import calculator.view.ResultView;
import calculator.domain.Calculator;

public class CalculatorController {
    public void start() {
        int result = Calculator.calculate(InputView.getUserInput());

        ResultView.printResult(result);
    }
}
