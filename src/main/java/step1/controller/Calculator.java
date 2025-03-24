package step1.controller;

import step1.domain.Expression;
import step1.domain.ExpressionParser;
import step1.domain.Operand;
import step1.view.InputView;
import step1.view.ResultView;

public class Calculator {

    public static void main(String[] args) {
        String expressionString = InputView.getExpressionString();
        Expression expression = ExpressionParser.parse(expressionString);
        Operand result = expression.evaluate();
        ResultView.printResult(result);
    }
}
