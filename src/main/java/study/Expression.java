package study;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Expression {
    private final List<Integer> expression;

    public Expression(String...expression) {
        this.expression = Arrays.stream(expression)
                                .map(ExpressionValidator::convertBlankOrNullToZero)
                                .map(ExpressionValidator::convertIfValidNumber)
                                .filter(ExpressionValidator::isPositiveNumber)
                                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayDeque<Integer> convertToQueue() {
        return new ArrayDeque<>(expression);
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
