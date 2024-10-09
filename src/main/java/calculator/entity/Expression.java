package calculator.entity;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expression that = (Expression) o;
        return calculateExpression == that.calculateExpression;
    }

    @Override
    public int hashCode() {
        return Objects.hash(calculateExpression);
    }
}
