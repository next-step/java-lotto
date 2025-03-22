package stringcalcaulator.domain;

import java.util.Arrays;

public enum Operator {
    ADD("+") {
        @Override
        public int calculate(int left, int right) {
            return left + right;
        }
    },
    SUB("-") {
        @Override
        public int calculate(int left, int right) {
            return left - right;
        }
    },
    MUL("*") {
        @Override
        public int calculate(int left, int right) {
            return left * right;
        }
    },
    DIV("/") {
        @Override
        public int calculate(int left, int right) {
            return left / right;
        }
    },
    ;

    private final String symbol;

    public static boolean isOperator(String token) {
        return Arrays.stream(Operator.values())
            .anyMatch(operatorToken -> operatorToken.isMatchSymbol(token));
    }

    public static Operator from(String token) {
        return Arrays.stream(Operator.values())
            .filter(operatorToken -> operatorToken.isMatchSymbol(token))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("해당 연산자를 찾을 수 없습니다."));
    }

    private boolean isMatchSymbol(String symbol) {
        return this.symbol.equals(symbol);
    }

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public abstract int calculate(int left, int right);
}
