package calculator;

import java.util.Arrays;

import static util.ErrorMessage.INVALID_NUMBER;
import static util.ErrorMessage.INVALID_OPERATOR;

public enum Operator {
    PLUS("+") {
        @Override
        public int apply(final int a, final int b) {
            return a + b;
        }
    },
    MINUS("-") {
        @Override
        public int apply(final int a, final int b) {
            return a - b;
        }
    },
    MULTIPLY("*") {
        @Override
        public int apply(final int a, final int b) {
            return a * b;
        }
    },
    DIVIDE("/") {
        @Override
        public int apply(final int a, final int b) {
            if (b == 0) {
                throw new ArithmeticException(INVALID_NUMBER);
            }
            return a / b;
        }
    };

    private final String symbol;

    Operator(final String symbol) {
        this.symbol = symbol;
    }

    public abstract int apply(final int a, final int b);

    public static Operator from(final String symbol) {
        return Arrays.stream(values())
                .filter(op -> op.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_OPERATOR));
    }
}
