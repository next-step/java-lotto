package calculator;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.ResultView;

public class CalculatorApp {

    public static void main(String[] args) {
        String input = InputView.getExpressions();

        ResultView.printCalculateResult(Calculator.calculate(input));
    }
}
