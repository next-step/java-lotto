public enum ArithmeticOperator implements Operator {
    PLUS("+") {
        @Override
        public int calculate(int a, int b) {
            return a + b;
        }
    }, MINUS("-") {
        @Override
        public int calculate(int a, int b) {
            return a - b;
        }
    }, MULTIPLY("*") {
        @Override
        public int calculate(int a, int b) {
            return a * b;
        }
    }, DIVIDE("/") {
        @Override
        public int calculate(int a, int b) {
            return a / b;
        }
    };

    private String symbol;

    ArithmeticOperator(String s) {
        this.symbol = s;
    }

    public static ArithmeticOperator from(String symbol) {
        for (ArithmeticOperator op : values()) {
            if (op.symbol.equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 연산자 입니다. " + symbol);
    }
}
