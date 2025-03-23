package calculator.domain;

import java.util.Arrays;

public enum Operator{
    PLUS("+") {
        @Override
        public int calculate(int left, int right) {
            return left + right;
        }
    },
    MINUS("-") {
        @Override
        public int calculate(int left, int right) {
            return left - right;
        }
    },
    MULTIPLY("*") {
        @Override
        public int calculate(int left, int right) {
            return left * right;
        }
    },
    DIVIDE("/") {
        @Override
        public int calculate(int left, int right) {
            return left / right;
        }
    };

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public abstract int calculate(int left, int right);

    public static Operator getOperatorBySymbol(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.isSameSymbol(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 연산자입니다. 입력된 연산자: " + symbol));
    }

    private boolean isSameSymbol(String symbol) {
        return this.symbol.equals(symbol);
    }
}
