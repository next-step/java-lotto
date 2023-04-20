package domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (num1, num2) -> Integer.valueOf(num1 + num2)),
    MINUS("-", (num1, num2) -> Integer.valueOf(num1 - num2)),
    MULTIPLY("*", (num1, num2) -> Integer.valueOf(num1 * num2)),
    DIVIDE("/", (num1, num2) -> Integer.valueOf(num1 / num2));

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> calculator;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> calculator) {
        this.operator = symbol;
        this.calculator = calculator;
    }

    public String getOperator() {
        return operator;
    }

    public static Integer calculator(String operator, Integer num1, Integer num2) {
        return getOperator(operator).calculator.apply(num1, num2);
    }

    private static Operator getOperator(String operator) {
        return Arrays.stream(values())
                .filter(o -> o.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙 연산 기호만 가능합니다."));
    }
}
