package stringcalculator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum OperationType {

    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> expression;

    OperationType(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public int calculate(int num1, int num2) {
        return expression.apply(num1, num2);
    }

    public static OperationType getOperator(String inputString) {
        return Arrays.stream(values())
                .filter(operationType -> operationType.isEquals(inputString))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 연산자가 존재하지 않습니다."));
    }

    private boolean isEquals(String operator) {
        return operator.equals(this.operator);
    }
}
