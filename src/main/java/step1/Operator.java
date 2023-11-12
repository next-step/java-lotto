package step1;

public enum Operator {
    PLUS('+') {
        @Override
        public int apply(int leftNumber, int rightNumber) {
            return leftNumber + rightNumber;
        }
    },
    MINUS('-') {
        @Override
        public int apply(int leftNumber, int rightNumber) {
            return leftNumber - rightNumber;
        }
    },
    MULTIPLICATION('*') {
        @Override
        public int apply(int leftNumber, int rightNumber) {
            return leftNumber * rightNumber;
        }
    },
    DIVISION('/') {
        @Override
        public int apply(int leftNumber, int rightNumber) {
            return leftNumber / rightNumber;
        }
    };

    private final char symbol;

    Operator(char symbol) {
        this.symbol = symbol;
    }

    public static Operator findOperatorByUserInput(char symbol) {
        for (Operator op : values()) {
            if (op.symbol == symbol) {
                return op;
            }
        }
        throw new IllegalArgumentException("사칙연산의 기호가 아닙니다");
    }

    public abstract int apply(int leftNumber, int rightNumber);
}