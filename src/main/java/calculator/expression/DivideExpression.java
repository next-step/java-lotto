package calculator.expression;

public class DivideExpression extends OperationExpression {

    private static final String OPERATION = "/";

    public DivideExpression(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    static boolean isSupport(String operation) {
        return OPERATION.equals(operation);
    }

    @Override
    protected NumberExpression execute(NumberExpression left, NumberExpression right) {
        return left.divide(right);
    }
}
