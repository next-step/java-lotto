package calculator.expression;

public abstract class OperationExpression implements Expression {

    private final Expression leftExpression;
    private final Expression rightExpression;

    public OperationExpression(Expression leftExpression, Expression rightExpression) {
        if (isUnValid(leftExpression, rightExpression)) {
            throw new IllegalArgumentException("올바른 연산 구조가 아닙니다.");
        }
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    private static boolean isUnValid(Expression leftExpression, Expression rightExpression) {
        return leftExpression == null || rightExpression == null;
    }

    @Override
    public NumberExpression calc() {
        NumberExpression left = leftExpression.calc();
        NumberExpression right = rightExpression.calc();
        return execute(left, right);
    }

    protected abstract NumberExpression execute(NumberExpression left, NumberExpression right);
}
