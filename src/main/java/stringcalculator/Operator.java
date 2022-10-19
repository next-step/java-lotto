package stringcalculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> {
        if (num2 == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return num1 / num2;
    }
    );

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public int calculate(int num1, int num2) {
        return expression.apply(num1, num2);
    }

    public static Operator getExpression(String operator) {
        return Arrays.stream(values())
                .filter(value -> value.operator.equals(operator))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 연산자입니다."));
    }
}
