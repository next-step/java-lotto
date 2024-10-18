package calculator.expression;

public class PlusExpression extends OperationExpression {

    private static final String OPERATION = "+";

    public PlusExpression(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    static boolean isSupport(String operation) {
        return OPERATION.equals(operation);
    }

    @Override
    protected NumberExpression execute(NumberExpression left, NumberExpression right) {
        return left.sum(right);
    }
}
