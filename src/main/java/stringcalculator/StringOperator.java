package stringcalculator;

public enum StringOperator {
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
                throw new ArithmeticException("Division by zero");
            }
            return a / b;
        }
    };

    private String symbol;

    StringOperator(String symbol) {
        this.symbol = symbol;
    }

    public abstract int apply(int a, int b);

    public static StringOperator fromString(String op) {
        for (StringOperator operator : values()) {
            if (operator.symbol.equals(op)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("Invalid operator: " + op);
    }

}