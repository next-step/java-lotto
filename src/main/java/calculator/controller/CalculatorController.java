package calculator.controller;

import calculator.model.Calculator;
import calculator.model.Expression;
import calculator.view.InputView;

public class CalculatorController {

    public static void main(String[] args) {
        // input
        String expression = InputView.inputExpression();

        // calculate
        int result = Calculator.run(new Expression(expression));

        // output

    }
}
