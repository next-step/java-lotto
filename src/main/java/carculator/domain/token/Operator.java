package carculator.domain.token;

import java.util.Arrays;

public enum Operator implements Token {
    PLUS("+") {
        @Override
        public int apply(Operand a, Operand b) {
            return a.plus(b);
        }
    },
    MINUS("-") {
        @Override
        public int apply(Operand a, Operand b) {
            return a.minus(b);
        }
    },
    MULTIPLY("*") {
        @Override
        public int apply(Operand a, Operand b) {
            return a.multiply(b);
        }
    },
    DIVIDE("/") {
        @Override
        public int apply(Operand a, Operand b) {
            return a.divide(b);
        }
    };

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public abstract int apply(Operand a, Operand b);

    public static Operator from(String symbol) {
        return Arrays.stream(values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(symbol + " is not a valid operator"));
    }
}
