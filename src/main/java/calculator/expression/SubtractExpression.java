package calculator.expression;

public class SubtractExpression extends OperationExpression {

    private static final String OPERATION = "-";

    public SubtractExpression(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    static boolean isSupport(String operation) {
        return OPERATION.equals(operation);
    }

    @Override
    protected NumberExpression execute(NumberExpression left, NumberExpression right) {
        return left.subtract(right);
    }
}
