package calculator;

import calculator.controller.Calculator;
import calculator.ui.InputView;
import calculator.ui.ResultView;
import calculator.util.Parser;

public class CalculatorApplication {
    public static void main(String[] args) {
        String expression = InputView.getExpression();
        Calculator calculator = Parser.parse(expression);

        ResultView.printResult(calculator.calculate().toString());
    }
}
