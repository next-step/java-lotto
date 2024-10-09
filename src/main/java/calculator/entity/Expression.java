package calculator.entity;

public class Expression {

    private final CalculateExpression calculateExpression;

    public Expression(CalculateExpression calculateExpression) {
        this.calculateExpression = calculateExpression;
    }

    public int result(int prevNumber, int number) {
        return this.calculateExpression.result(prevNumber, number);
    }

    public boolean isMatch(String expression) {
        return this.calculateExpression.isMatch(expression);
    }
}
