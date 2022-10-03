package calculator.domain;

import java.util.Arrays;

public enum Operator {
    ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVIDE("/");

    private static final String NOT_OPERATOR_MESSAGE = "연산자(+,-,*,/)의 위치에 연산자가 아닌 값이 입력되었습니다.";

    private final String value;

    Operator(String value) {
        this.value = value;
    }

    public static Operator of(final String value) {
        return Arrays.stream(values())
                .filter(o -> o.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_OPERATOR_MESSAGE));
    }

    public static boolean isOperator(final String value) {
        return Arrays.stream(Operator.values()).anyMatch(operator -> operator.value.equals(value));
    }
}
