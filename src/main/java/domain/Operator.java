package domain;

import java.util.Arrays;

public enum Operator {
    PLUS("+") {
        public int apply(int a, int b) {
            return a + b;
        }
    },
    MINUS("-") {
        public int apply(int a, int b) {
            return a - b;
        }
    },
    MULTIPLY("*") {
        public int apply(int a, int b) {
            return a * b;
        }
    },
    DIVIDE("/") {
        public int apply(int a, int b) {
            return a / b;
        }
    };

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public abstract int apply(int a, int b);

    public static Operator from(String symbol) {
        return Arrays.stream(values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 연산자입니다."));
    }
}
