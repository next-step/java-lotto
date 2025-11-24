package calculate.domain;

public enum Calculator implements Operator {

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

    Calculator(String symbol) {
        this.symbol = symbol;
    }

    public static Calculator fromSymbol(String symbol) {
        for (Calculator value : values()) {
            if (value.symbol.equals(symbol)) {
                return value;
            }
        }
        throw new IllegalArgumentException();
    }
}
