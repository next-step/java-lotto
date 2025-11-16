package calculator;

public enum OperatorType {
    PLUS("+") {
        @Override
        public int calculate(int operand1, int operand2) {
            return operand1 + operand2;
        }
    },
    MINUS("-") {
        @Override
        public int calculate(int operand1, int operand2) {
            return operand1 - operand2;
        }
    },
    MULTIPLY("*") {
        @Override
        public int calculate(int operand1, int operand2) {
            return operand1 * operand2;
        }
    },
    DIVIDE("/") {
        @Override
        public int calculate(int operand1, int operand2) {
            return operand1 / operand2;
        }
    };

    private final String symbol;

    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    public abstract int calculate(int operand1, int operand2);

    public static OperatorType from(String symbol) {
        for (OperatorType operatorType : OperatorType.values()) {
            if (operatorType.symbol.equals(symbol)) {
                return operatorType;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 연산자");
    }
}
