package calculator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (number1, number2) -> Integer.valueOf(number1 + number2)),
    MINUS("-", (number1, number2) -> Integer.valueOf(number1 - number2)),
    MULTIPLY("*", (number1, number2) -> Integer.valueOf(number1 * number2)),
    DIVIDE("/", (number1, number2) -> Integer.valueOf(number1 / number2));

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> calculator;

    Operator(String operator, BiFunction<Integer, Integer, Integer> calculator) {
        this.operator = operator;
        this.calculator = calculator;
    }

    public String getOperator() {
        return operator;
    }

    public static Integer calculate(String operator, Integer number1, Integer number2) {
        return getOperator(operator).calculator.apply(number1, number2);
    }

    private static Operator getOperator(String operator) {
        return Arrays.stream(values())
                .filter(o -> o.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호만 가능합니다."));
    }
}
