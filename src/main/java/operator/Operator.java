package operator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> {
        validateDivision(num1, num2);
        return num1 / num2;
    });

    private String operator;
    private BiFunction<Integer, Integer, Integer> expression;

    Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static int calculate(int num1, String operator, int num2) {
        return getOperator(operator).expression.apply(num1, num2);
    }

    private static Operator getOperator(String operator) {
        return Arrays.stream(values())
                .filter(o -> o.operator.equals(operator))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("올바른 연산자가 아닙니다."));
    }

    private static void validateDivision(int left, int right) {
        checkZero(right);
        checkInteger(left, right);
    }

    private static void checkZero(int right) {
        if (right == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }

    private static void checkInteger(int left, int right) {
        if (left % right != 0) {
            throw new IllegalArgumentException("정수로 나누어지지 않습니다.");
        }
    }
}
