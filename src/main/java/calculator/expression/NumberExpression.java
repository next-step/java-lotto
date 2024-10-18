package calculator.expression;

import java.util.Objects;

public class NumberExpression implements Expression {

    private final int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    public NumberExpression(String value) {
        this(Integer.parseInt(value));
    }

    @Override
    public NumberExpression calc() {
        return this;
    }

    public int value() {
        return this.number;
    }

    NumberExpression sum(NumberExpression expression) {
        return new NumberExpression(this.number + expression.number);
    }

    NumberExpression subtract(NumberExpression expression) {
        return new NumberExpression(this.number - expression.number);
    }

    NumberExpression multiply(NumberExpression expression) {
        return new NumberExpression(this.number * expression.number);
    }

    NumberExpression divide(NumberExpression expression) {
        return new NumberExpression(this.number / expression.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NumberExpression that = (NumberExpression) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
