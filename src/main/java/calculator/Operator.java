package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    DIVIDE("/", (num1, num2) -> num1 / num2),
    SQUARE("*", (num1, num2) -> num1 * num2),
    NONE("", (num1, num2) -> num2);

    private final String value;
    private final BiFunction<Integer, Integer, Integer> operator;

    Operator(String value, BiFunction<Integer, Integer, Integer> operator) {
        this.value = value;
        this.operator = operator;
    }

    public int calculate(int result, int expression) {
        return operator.apply(result, expression);
    }

    public static Operator findOperationByValue(String value) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.isValueEqualsTo(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유요하지 않은 연산자: " + value));
    }

    private boolean isValueEqualsTo(String value) {
        return this.value.equals(value);
    }
}
