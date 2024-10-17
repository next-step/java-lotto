package calculator.expression;

public class DivideExpression extends OperationExpression {

    public DivideExpression(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    protected NumberExpression execute(NumberExpression left, NumberExpression right) {
        return left.divide(right);
    }
}
