package step1.arithmeticExpression;

import step1.arithmeticExpression.numbers.Numbers;
import step1.arithmeticExpression.operators.Operators;

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
