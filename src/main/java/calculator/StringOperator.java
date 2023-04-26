package calculator;

import java.util.Arrays;

enum StringOperator {
    ADD("+"), SUB("-"), DIV("/"), MUL("*");

    final private String operator;

    StringOperator(String operator) {
        this.operator = operator;
    }

    public static StringOperator of(String operator) {
        return Arrays.stream(StringOperator.values())
                .filter(stringOperator -> stringOperator.is(operator))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 연산자입니다."));
    }

    private boolean is(String operator) {
        return this.operator.equals(operator);
    }
}
