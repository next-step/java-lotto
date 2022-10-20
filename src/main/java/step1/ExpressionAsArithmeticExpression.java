package step1;

import step1.numbers.ExpressionAsNumbers;
import step1.numbers.Numbers;
import step1.operators.ExpressionAsOperators;
import step1.operators.Operators;

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
    }


}
