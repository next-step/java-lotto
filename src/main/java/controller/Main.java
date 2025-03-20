package controller;

import calculator.Calculator;
import view.InputView;
import view.OutputView;

public class Main {

    public static void main(String[] args) {
        String input = InputView.getExpression();

        Calculator calculator = new Calculator(input);
        int result = calculator.calculate();

        OutputView.printResult(result);
    }

}
