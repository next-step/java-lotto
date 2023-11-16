package calculator.util;

import calculator.domain.Number;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {

    ADD("+", (a, b) -> add(a, b)),
    SUBTRACT("-", (a, b) -> subtract(a, b)),
    MULTIPLY("*", (a, b) -> multiply(a, b)),
    DIVIDE("/", (a, b) -> divide(a, b));

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

    private static Number add(Number left, Number right) {
        return new Number(left.value() + right.value());
    }

    private static Number subtract(Number left, Number right) {
        return new Number(left.value() - right.value());
    }

    private static Number multiply(Number left, Number right) {
        return new Number(left.value() * right.value());
    }

    private static Number divide(Number left, Number right) {
        if (right.value() == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return new Number(left.value() / right.value());
    }

}
