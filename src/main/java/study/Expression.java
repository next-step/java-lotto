package study;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Expression {
    private final List<String> expression;

    public Expression(String...expression) {
        this.expression = Arrays.asList(expression);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Expression that = (Expression) o;
        return expression.equals(that.expression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expression);
    }
}
