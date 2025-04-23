package stringCalculator.controller;

import stringCalculator.domain.Expression;
import stringCalculator.view.InputView;
import stringCalculator.view.ResultView;

public class StringCalculator {
        public static void main(String[] args) {
                Expression expression = InputView.getExpression();
                int result = expression.calculate();
                ResultView.printResult(result);
        }
}
