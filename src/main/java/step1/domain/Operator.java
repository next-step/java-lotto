package step1.domain;

import java.util.Arrays;

public enum Operator {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private static final String UNSUPPORTED_OPERATOR_EXCEPTION_MESSAGE = "허용하지 않는 사칙연산 기호입니다.";

    private final String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public static Operator of(String operator) {
        return Arrays.stream(values())
            .filter(o -> o.operator.equals(operator))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(UNSUPPORTED_OPERATOR_EXCEPTION_MESSAGE));
    }
}
