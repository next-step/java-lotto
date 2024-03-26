package calculator;

import calculator.service.StringCalculator;
import calculator.view.InputView;
import calculator.view.ResultView;

public class StringCalculatorApplication {
    private static final StringCalculator stringCalculator = new StringCalculator();

    public static void main (String[] args) {
        String input = InputView.mathematicalExpressionString();
        int result = stringCalculator.result(input);
        ResultView.result(result);
    }
}
