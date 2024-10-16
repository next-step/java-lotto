package controller;

import service.calculator.Calculator;

public class CalculatorController {

    public static void main(String[] args) {
        String calculationString = InputView.inputCalculationString();

        int result = Calculator.calculate(calculationString);

        ResultView.printResult(result);
    }

}
