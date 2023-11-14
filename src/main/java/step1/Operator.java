package step1;

public enum Operator {
    PLUS("+") {
        @Override
        public int apply(Integer leftNumber, Integer rightNumber) {
            return leftNumber + rightNumber;
        }
    },
    MINUS("-") {
        @Override
        public int apply(Integer leftNumber, Integer rightNumber) {
            return leftNumber - rightNumber;
        }
    },
    MULTIPLICATION("*") {
        @Override
        public int apply(Integer leftNumber, Integer rightNumber) {
            return leftNumber * rightNumber;
        }
    },
    DIVISION("/") {
        @Override
        public int apply(Integer leftNumber, Integer rightNumber) {
            return leftNumber / rightNumber;
        }
    };

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public static Operator findOperatorByUserInput(String symbol) {
        for (Operator op : values()) {
            if (op.symbol.equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("사칙연산의 기호가 아닙니다");
    }

    public abstract int apply(Integer leftNumber, Integer rightNumber);
}