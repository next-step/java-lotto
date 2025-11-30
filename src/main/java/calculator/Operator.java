package calculator;

public enum Operator {

    ADD("+") {
        @Override
        public int apply(int a, int b) {
            return a + b;
        }
    },
    SUBTRACT("-") {
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
            if (b == 0) {
                throw new IllegalArgumentException(ERROR_DIVIDE_BY_ZERO);
            }
            return a / b;
        }
    };

    private final String symbol;
    public static final String ERROR_DIVIDE_BY_ZERO = "0으로 나눌 수 없습니다";
    private static final String ERROR_INVALID_OPERATOR = "사용할 수 없는 연산자입니다";

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public abstract int apply(int a, int b);

    public static Operator fromString(String symbol) {
        for (Operator op : values()) {
            if (op.symbol.equals(symbol)) return op;
        }
        throw new IllegalArgumentException(ERROR_INVALID_OPERATOR);
    }
}

