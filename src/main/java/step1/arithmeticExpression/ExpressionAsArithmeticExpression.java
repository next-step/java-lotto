package step1.arithmeticExpression;

import step1.arithmeticExpression.numbers.ExpressionAsNumbers;
import step1.arithmeticExpression.numbers.Numbers;
import step1.arithmeticExpression.operators.ExpressionAsOperators;
import step1.arithmeticExpression.operators.Operators;

public class ExpressionAsArithmeticExpression {

    private final String expression;

    public ExpressionAsArithmeticExpression(String expression) {
        this.expression = expression;
    }

    public Numbers numbers() {
        verifyValidExpression();

        return new Numbers(new ExpressionAsNumbers(expression));
    }

    public Operators operators() {
        verifyValidExpression();

        return new Operators(new ExpressionAsOperators(expression));
    }

    public void verifyValidExpression() {
        if (expression == null) {
            throw new IllegalStateException("유효한 연산식이 아닙니다.");
        }

        if (!expression.matches("^([+\\-]?\\d+)( [+\\-/*] \\d+)*")) {
            throw new IllegalStateException("유효한 연산식이 아닙니다.");
        }

        if (expression.contains("/ 0")) {
            throw new IllegalStateException("0으로 나눌 수 없습니다.");
        }
    }
}
