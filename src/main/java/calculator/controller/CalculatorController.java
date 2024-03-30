package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    public static void main(String[] args) {
        String inputFormula = InputView.inputFormula();

        int totalSum = Calculator.calculate(inputFormula);
        OutputView.printResult(totalSum);
    }
}
