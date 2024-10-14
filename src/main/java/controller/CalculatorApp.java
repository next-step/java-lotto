package controller;

import domain.Calculator;
import domain.Tokens;
import view.InputView;
import view.ResultView;

public class CalculatorApp {
    public static void main(String[] args) {
        Tokens tokens = InputView.getTokens();
        Calculator calculator = new Calculator(tokens);
        int result = calculator.calculate();
        ResultView.printResult(result);
    }
}
