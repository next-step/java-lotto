package calculator;

public enum Operator {
    PLUS("+") {
        @Override
        PositiveNumber apply(PositiveNumber left, PositiveNumber right) {
            return left.plus(right);
        }
    },
    MINUS("-") {
        @Override
        PositiveNumber apply(PositiveNumber left, PositiveNumber right) {
            return left.minus(right);
        }
    },
    MULTIPLY("*") {
        @Override
        PositiveNumber apply(PositiveNumber left, PositiveNumber right) {
            return left.multiply(right);
        }
    },
    DIVIDE("/") {
        @Override
        PositiveNumber apply(PositiveNumber left, PositiveNumber right) {
            return left.divide(right);
        }
    };

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    abstract PositiveNumber apply(PositiveNumber left, PositiveNumber right);

    static Operator from(String symbol) {
        for (Operator operator : values()) {
            if (operator.symbol.equals(symbol)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("사칙연산 기호가 아닙니다: " + symbol);
    }
}
