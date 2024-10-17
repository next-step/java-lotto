package calculator;

public class PlusExpression extends OperationExpression {

    public PlusExpression(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    protected NumberExpression execute(NumberExpression left, NumberExpression right) {
        return left.sum(right);
    }
}
