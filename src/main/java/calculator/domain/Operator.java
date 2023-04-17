package calculator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", Integer::sum),
    MINUS("-", (operand1, operand2) -> (operand1 - operand2)),
    MULTIPLE("*", (operand1 , operand2) -> (operand1 * operand2)),
    DIVIDE("/", (operand1, operand2) -> {
        isDividedByZero(operand2);
        return operand1 / operand2;
    });

    public static final int ZERO = 0;

    private static void isDividedByZero(Integer operand2) {
        if (operand2 == ZERO) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> calculation;

    Operator(String operator, BiFunction<Integer, Integer, Integer> calculation) {
        this.operator = operator;
        this.calculation = calculation;
    }

    public static int calculate(Operator operator, int operand1, int operand2) {
        return operator.calculation.apply(operand1, operand2);
    }

    public static Operator getOperator(String operator) {
        return Arrays.stream(values())
                .filter(o -> o.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 연산자가 아닙니다."));
    }
}
