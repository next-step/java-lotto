package calculator;

import static java.util.Arrays.stream;

public enum Operator {
    ADD("+") {
        @Override
        public int apply(int left, int right) {
            return left + right;
        }
    },
    SUB("-") {
        @Override
        public int apply(int left, int right) {
            return left - right;
        }
    },
    MUL("*") {
        @Override
        public int apply(int left, int right) {
            return left * right;
        }
    },
    DIV("/") {
        @Override
        public int apply(int left, int right) {
            return left / right;
        }
    };

    private final String symbol;
    Operator(String symbol) {
        this.symbol = symbol;
    }

    static Operator from(String symbol) {
        return stream(Operator.values())
                .filter(op -> op.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호가 아닙니다."));
    }

    public abstract int apply(int left, int right);
}
