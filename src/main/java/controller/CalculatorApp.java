package controller;

import domain.Calculator;
import domain.Tokens;
import view.InputView;
import view.ResultView;

public class CalculatorApp {
    public static void main(String[] args) {
        String expression = InputView.getExpression();
        Tokens tokens = new Tokens(expression);
        tokens.validate();
        Calculator calculator = new Calculator(tokens);
        int result = calculator.calculate();
        ResultView.printResult(result);
    }
}
