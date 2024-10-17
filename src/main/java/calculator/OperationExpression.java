package calculator;

public abstract class OperationExpression implements Expression {

    private final Expression leftExpression;
    private final Expression rightExpression;

    public OperationExpression(Expression leftExpression, Expression rightExpression) {
        if (leftExpression == null || rightExpression == null) {
            throw new IllegalArgumentException("올바른 연산 구조가 아닙니다.");
        }
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public NumberExpression calc() {
        NumberExpression left = leftExpression.calc();
        NumberExpression right = rightExpression.calc();
        return execute(left, right);
    }

    protected abstract NumberExpression execute(NumberExpression left, NumberExpression right);
}
