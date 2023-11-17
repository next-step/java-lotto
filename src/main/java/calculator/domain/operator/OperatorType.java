package calculator.domain.operator;

import java.util.Arrays;

public enum OperatorType {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/"),
    ;

    private final String field;

    OperatorType(String field) {
        this.field = field;
    }

    public static OperatorType of(String field) {
        return Arrays.stream(values())
                .filter(v -> field.equals(v.field))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하는 연산기호가 아닙니다."));
    }
}
