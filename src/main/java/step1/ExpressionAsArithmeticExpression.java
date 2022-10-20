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
        return new Numbers(new ExpressionAsNumbers(expression));
    }

    public Operators operators() {
        return new Operators(new ExpressionAsOperators(expression));
    }
}
