package calculator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

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
        if (this == DIVIDE && num2 == 0) {
            throw new IllegalArgumentException("0 으로 나눌 수 없습니다.");
        }
        return expression.apply(num1, num2);
    }
}
