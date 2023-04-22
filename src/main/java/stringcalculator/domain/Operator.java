package stringcalculator.domain;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {
    ADDITION("+", (o1, o2) -> o1 + o2),
    SUBTRACTION("-", (o1, o2) -> o1 - o2),
    MULTIPLICATION("*", (o1, o2) -> o1 * o2),
    DIVISION("/", (o1, o2) -> o1 / o2);

    private final String operator;
    private final BinaryOperator<Integer> binaryOperator;

    Operator(String operator, BinaryOperator<Integer> binaryOperator) {
        this.operator = operator;
        this.binaryOperator = binaryOperator;
    }

    public static Operator of(String operator) {
        return Arrays.stream(values())
                .filter(e -> e.operator.equals(operator))
                .findAny()
                .orElseThrow(()
                        -> new IllegalArgumentException("사칙연산의 기호가 아닙니다."));
    }

    public int operate(int o1, int o2) {
        if (operator.equals("/")) {
            validateDividing(o1, o2);
        }
        return binaryOperator.apply(o1, o2);
    }

    private void validateDividing(int o1, int o2) {
        if (o1 % o2 != 0) {
            throw new IllegalArgumentException("약수만 사용할 수 있습니다.");
        }
    }
}
