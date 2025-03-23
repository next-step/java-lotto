package step1;

public enum Operator {
    PLUS('+') {
        @Override
        public Operand apply(Operand left, Operand right) {
            return new Operand(left.value() + right.value());
        }
    },
    MINUS('-') {
        @Override
        public Operand apply(Operand left, Operand right) {
            return new Operand(left.value() - right.value());
        }
    },
    MULTIPLY('*') {
        @Override
        public Operand apply(Operand left, Operand right) {
            return new Operand(left.value() * right.value());
        }
    },
    DIVIDE('/') {
        @Override
        public Operand apply(Operand left, Operand right) {
            if (left.value() % right.value() != 0) {
                throw new RuntimeException("나눗셈 결과는 정수로 떨어져야 합니다.");
            }
            if (right.value() == 0) {
                throw new RuntimeException("0으로 나눌 수 없습니다.");
            }
            return new Operand(left.value() / right.value());
        }
    };

    private final char symbol;

    Operator(char symbol) {
        this.symbol = symbol;
    }

    public char symbol() {
        return this.symbol;
    }

    public abstract Operand apply(Operand left, Operand right);
}
