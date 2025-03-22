package carculator.domain.token;

import java.util.Arrays;

public enum Operator implements Token {
    PLUS("+") {
        @Override
        public int apply(int a, int b) {
            return a + b;
        }
    },
    MINUS("-") {
        @Override
        public int apply(int a, int b) {
            return a - b;
        }
    },
    MULTIPLY("*") {
        @Override
        public int apply(int a, int b) {
            return a * b;
        }
    },
    DIVIDE("/") {
        @Override
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
                .orElseThrow(() -> new IllegalArgumentException(symbol + " is not a valid operator"));
    }
}
