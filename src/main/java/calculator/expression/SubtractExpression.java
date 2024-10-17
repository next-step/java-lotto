package calculator.expression;

public class SubtractExpression extends OperationExpression {

    public SubtractExpression(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    protected NumberExpression execute(NumberExpression left, NumberExpression right) {
        return left.subtract(right);
    }
}
