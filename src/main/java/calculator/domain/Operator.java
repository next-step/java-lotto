package calculator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String value;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String value, BiFunction<Integer, Integer, Integer> expression) {
        this.value = value;
        this.expression = expression;
    }

    public static Operator of(String symbol) {
        return Arrays.stream(values())
                .filter(operator -> operator.value.equals(symbol))
                .findFirst()
                .orElseThrow();
    }

    public int calculate(int num1, int num2) {
        return expression.apply(num1, num2);
    }
}
