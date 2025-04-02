package step1;

public enum StringOperator implements Operator {
    ADDITION("+") {
        public int apply(int a, int b) {
            return a + b;
        }
    },
    SUBTRACTION("-") {
        public int apply(int a, int b) {
            return a - b;
        }
    },
    MULTIPLICATION("*") {
        public int apply(int a, int b) {
            return a * b;
        }
    },
    DIVISION("/") {
        public int apply(int a, int b) {
            return a / b;
        }
    },
    ;

    private final String symbol;

    StringOperator(String symbol) {
        this.symbol = symbol;
    }

    public static StringOperator from(String symbol) {
        for(StringOperator op: values()) {
            if (op.symbol.equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 연산자 입니다. " + symbol);
    }
}
