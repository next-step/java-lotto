package calculator.expression;

public class MultiplyExpression extends OperationExpression {

    public MultiplyExpression(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    protected NumberExpression execute(NumberExpression left, NumberExpression right) {
        return left.multiply(right);
    }
}
