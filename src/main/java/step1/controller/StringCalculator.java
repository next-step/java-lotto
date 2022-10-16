package step1.controller;

import step1.domain.Expression;
import step1.domain.Operand;
import step1.domain.Operator;
import step1.view.InputView;
import step1.view.ResultView;

public class StringCalculator {

    private StringCalculator() {

    }

    public static void calculate() {
        String rawExpression = InputView.getExpression();
        Expression expression = Expression.from(rawExpression);
        Operand result = expression.getOperands().poll();
        for (Operand operand : expression.getOperands()) {
            Operator operator = expression.getOperators().poll();
            result = operator.operate(result, operand);
        }
        ResultView.print(result);
    }
}
