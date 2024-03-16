package calculator.domain;

import calculator.view.InputView;
import calculator.view.ResultView;

public class StringCalculator {
    public void calculate() {
        Expression expression = new Expression(InputView.askExpression());
        ResultView.printResult(expression.result());
    }
}
