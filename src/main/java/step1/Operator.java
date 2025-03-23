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
