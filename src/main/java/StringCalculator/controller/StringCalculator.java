package StringCalculator.controller;

import StringCalculator.domain.Expression;
import StringCalculator.view.InputView;
import StringCalculator.view.ResultView;

public class StringCalculator {
        public static void main(String[] args) {
                Expression expression = InputView.getExpression();
                int result = expression.calculate();
                ResultView.printResult(result);
        }
}
