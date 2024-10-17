package stringcalculator.controller;

import stringcalculator.domain.Calculator;
import stringcalculator.domain.Tokens;
import stringcalculator.view.InputView;
import stringcalculator.view.ResultView;

public class CalculatorApp {
    public static void main(String[] args) {
        Tokens tokens = InputView.getTokens();
        Calculator calculator = new Calculator(tokens);
        int result = calculator.calculate();
        ResultView.printResult(result);
    }
}
