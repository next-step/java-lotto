package stringcalculator.model;


import java.util.Arrays;

public enum Operator {
    PLUS("+") {
        public Number calculate(Number a, Number b) {
            return new Number(a.getNumber() + b.getNumber());
        }
    },
    MINUS("-") {
        public Number calculate(Number a, Number b) {
            return new Number(a.getNumber() - b.getNumber());
        }
    },
    MULTIPLE("*") {
        public Number calculate(Number a, Number b) {
            return new Number(a.getNumber() * b.getNumber());
        }
    },
    DIVIDE("/") {
        public Number calculate(Number a, Number b) {
            validateDivisor(b);
            return new Number(a.getNumber() / b.getNumber());
        }
    };

    public static final String DIVIDE_ERROR_MESSAGE = "0으로 나눌수 없습니다!";
    public static final String EXCEPT_OPERATOR_ERROR_MESSAGE = "+, -, *, / 연산자를 입력해주세요!";

    private static void validateDivisor(Number number) {
        if (number.isZero()) {
            throw new IllegalArgumentException(DIVIDE_ERROR_MESSAGE);
        }
    }

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public static Operator of(String symbol) {
        return Arrays.stream(values())
                .filter(op -> op.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(EXCEPT_OPERATOR_ERROR_MESSAGE));
    }

    public abstract Number calculate(Number a, Number b);
}
