package calculator.expression;

public class MultiplyExpression extends OperationExpression {

    private static final String OPERATION = "*";

    public MultiplyExpression(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    static boolean isSupport(String operation) {
        return OPERATION.equals(operation);
    }

    @Override
    protected NumberExpression execute(NumberExpression left, NumberExpression right) {
        return left.multiply(right);
    }
}
