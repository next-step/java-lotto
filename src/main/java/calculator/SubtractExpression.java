package calculator;

public class SubtractExpression implements Expression {

    private Expression leftExpression;
    private Expression rightExpression;

    public SubtractExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public NumberExpression calc() {
        NumberExpression left = leftExpression.calc();
        NumberExpression right = rightExpression.calc();

        return left.subtract(right);
    }
}
