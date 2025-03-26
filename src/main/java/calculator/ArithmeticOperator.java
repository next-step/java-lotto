package calculator;

public enum ArithmeticOperator implements Operator {
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
    MULTIPLE("*") {
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

    ArithmeticOperator(String symbol) {
        this.symbol = symbol;
    }

    public static ArithmeticOperator from(String symbol) {
        for(ArithmeticOperator op: values()) {
            if (op.symbol.equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 연산자 입니다. " + symbol);
    }
}
