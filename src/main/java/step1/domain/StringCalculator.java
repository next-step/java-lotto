package step1.domain;

import step1.utils.ExpressionSplitter;

public class StringCalculator {

    private Expression expression;

    public StringCalculator(final String inputExpression) {
        validateExpression(inputExpression);
        this.expression = new Expression(ExpressionSplitter.splitExpression(inputExpression));
    }

    public int calculateExecute() {
        return expression.calculate();
    }

    private void validateExpression(final String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("빈 문자열은 입력하실 수 없습니다.");
        }
    }

}
