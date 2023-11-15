package calculator.util;

import calculator.domain.Calculator;
import calculator.domain.Number;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

    ADD("+", (a, b) -> add(a, b)),
    SUBTRACT("-", (a, b) -> subtract(a, b)),
    MULTIPLY("*", (a, b) -> multiply(a, b)),
    DIVIDE("/", (a, b) -> divide(a, b));

    private final String label;
    private final BiFunction<Number, Number, Number> expression;
    private static Calculator calculator = new Calculator();

    Operator(final String label, BiFunction<Number, Number, Number> expression) {
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

    private static Number add(Number a, Number b) {
        return calculator.add(a, b);
    }

    private static Number subtract(Number a, Number b) {
        return calculator.subtract(a, b);
    }

    private static Number multiply(Number a, Number b) {
        return calculator.multiply(a, b);
    }

    private static Number divide(Number a, Number b) {
        return calculator.divide(a, b);
    }

}
