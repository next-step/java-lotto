package calculator;

public class PlusExpression {

    private NumberExpression leftExpression;
    private NumberExpression rightExpression;

    public PlusExpression(NumberExpression leftExpression, NumberExpression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    public NumberExpression calc() {
        return leftExpression.sum(rightExpression);
    }
}
