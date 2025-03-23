package step1;

public enum Operator {
    PLUS('+') {
        @Override
        public Operand apply(Operand left, Operand right) {
            return new Operand(left.getValue() + right.getValue());
        }
    },
    MINUS('-') {
        @Override
        public Operand apply(Operand left, Operand right) {
            return new Operand(left.getValue() - right.getValue());
        }
    },
    MULTIPLY('*') {
        @Override
        public Operand apply(Operand left, Operand right) {
            return new Operand(left.getValue() * right.getValue());
        }
    },
    DIVIDE('/') {
        @Override
        public Operand apply(Operand left, Operand right) {
            if (left.getValue() % right.getValue() != 0) {
                throw new RuntimeException("나눗셈 결과는 정수로 떨어져야 합니다.");
            }
            if (right.getValue() == 0) {
                throw new RuntimeException("0으로 나눌 수 없습니다.");
            }
            return new Operand(left.getValue() / right.getValue());
        }
    };

    private final char symbol;

    Operator(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public abstract Operand apply(Operand left, Operand right);

    public static Operator fromSymbol(char symbol) {
        if (symbol == '+') return Operator.PLUS;
        if (symbol == '-') return Operator.MINUS;
        if (symbol == '*') return Operator.MULTIPLY;
        if (symbol == '/') return Operator.DIVIDE;
        throw new RuntimeException("잘못된 연산자입니다.");
    }
}
