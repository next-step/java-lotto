package calculator;

import java.util.Objects;

public class NumberExpression implements Expression {

    private final int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    public NumberExpression(String value) {
        this(Integer.parseInt(value));
    }

    public NumberExpression sum(NumberExpression rightExpression) {
        return new NumberExpression(this.number + rightExpression.number);
    }

    @Override
    public NumberExpression calc() {
        return this;
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
