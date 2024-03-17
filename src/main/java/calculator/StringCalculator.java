package calculator;

import calculator.domain.Expression;
import calculator.view.InputView;
import calculator.view.ResultView;

public class StringCalculator {
    public static void main(String[] args) {
        Expression expression = new Expression(InputView.askExpression());
        ResultView.printResult(expression.result());
    }
}
