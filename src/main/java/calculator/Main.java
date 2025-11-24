package calculator;

import calculator.domain.StringCalculator;
import calculator.view.InputView;
import calculator.view.ResultView;

public class Main {
    public static void main(String[] args) {
        String expression = InputView.getExpression();

        ResultView.show(new StringCalculator(expression).calculate());
    }
}
