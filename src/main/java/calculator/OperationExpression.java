package calculator;

public abstract class OperationExpression implements Expression {

    private final Expression leftExpression;
    private final Expression rightExpression;

    public OperationExpression(Expression leftExpression, Expression rightExpression) {
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
