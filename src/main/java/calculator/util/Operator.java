package calculator.util;

import calculator.domain.Number;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {

    ADD("+", (left, right) -> {
        return new Number(left.value() + right.value());
    }),
    SUBTRACT("-", (left, right) -> {
        return new Number(left.value() - right.value());
    }),
    MULTIPLY("*", (left, right) -> {
        return new Number(left.value() * right.value());
    }),
    DIVIDE("/", (left, right) -> {
        if (right.value() == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return new Number(left.value() / right.value());
    });

    private final String label;
    private final BinaryOperator<Number> expression;

    Operator(final String label, BinaryOperator<Number> expression) {
        this.label = label;
        this.expression = expression;
    }

    public static Number calculate(Number leftValue, String operator, Number rightValue) {
        return findSymbols(operator).expression.apply(leftValue, rightValue);
    }

    private static Operator findSymbols(String operator) {
        return Arrays.stream(values())
                .filter(value -> value.label.equals(operator))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 연산자입니다."));
    }

}
