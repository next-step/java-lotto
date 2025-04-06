package calculator;

import java.util.Arrays;
import java.util.stream.Collectors;

import static common.ErrorMessage.INVALID_NUMBER;
import static common.ErrorMessage.INVALID_OPERATOR;

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

    public String getSymbol() {
        return this.symbol;
    }

    public static Operator from(final String symbol) {
        if (!isSupported(symbol)) {
            throw new IllegalArgumentException(INVALID_OPERATOR);
        }
        return Arrays.stream(values())
                .filter(op -> op.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_OPERATOR));
    }

    public static boolean isSupported(final String input) {
        return Arrays.stream(values())
                .anyMatch(op -> op.symbol.equals(input));
    }

    public static String supportSymbols() {
        return Arrays.stream(values())
                .map(Operator::getSymbol)
                .collect(Collectors.joining(", "));
    }
}
