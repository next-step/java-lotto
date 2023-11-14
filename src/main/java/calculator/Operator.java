package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

import static calculator.exception.CustomExceptionCode.NOT_FOUR_BASIC_OPERATIONS;

public enum Operator {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DEVIDE("/", (a, b) -> a / b);

    private final String sign;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String sign, BiFunction<Integer, Integer, Integer> expression) {
        this.sign = sign;
        this.expression = expression;
    }

    public static int calculate(int a, int b, String sign) {
        Operator operator = Arrays.stream(values())
                .filter(v -> v.sign.equals(sign))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUR_BASIC_OPERATIONS.getMessage()));

        return operator.expression.apply(a, b);
    }
}
