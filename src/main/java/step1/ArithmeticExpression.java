package step1;

import step1.numbers.Numbers;
import step1.operators.Operators;

public class ArithmeticExpression {

    private final ExpressionAsArithmeticExpression expressionAsArithmeticExpression;

    public ArithmeticExpression(ExpressionAsArithmeticExpression expressionAsArithmeticExpression) {
        this.expressionAsArithmeticExpression = expressionAsArithmeticExpression;
    }

    public int calculatedResult() {
        Numbers numbers = expressionAsArithmeticExpression.numbers();
        Operators operators = expressionAsArithmeticExpression.operators();

        return numbers.calculatedResult(operators);
    }

}
