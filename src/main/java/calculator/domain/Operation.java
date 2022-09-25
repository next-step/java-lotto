package calculator.domain;

import java.util.Arrays;

public enum Operation {

    PLUS("+") {
        public int apply(final int x, final int y) { return x + y; }
    },
    MINUS("-") {
        public int apply(final int x, final int y) { return x - y; }
    },
    MULTIPLY("*") {
        public int apply(final int x, final int y) { return x * y; }
    },
    DIVIDE("/") {
        public int apply(final int x, final int y) { return x / y; }
    };

    private final String operator;

    Operation(final String operator) {

        this.operator = operator;
    }

    public abstract int apply(final int x, final int y);

    public static Operation from(final String input) {

        return Arrays.stream(Operation.values())
                .filter(oper -> oper.getOperator().equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("+, -, * / 이외 다른 연산자는 불가능합니다."));
    }

    public String getOperator() {
        return operator;
    }
}