package calculator;

import java.util.Objects;

public class NumberExpression {

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
