package step1;

import java.util.Arrays;

public enum Operator {
    PLUS("+") {
        @Override
        public int calculate(int x, int y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public int calculate(int x, int y) {
            return x - y;
        }
    },
    MULTIPLY("*") {
        @Override
        public int calculate(int x, int y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        public int calculate(int x, int y) {
            if (y == 0) {
                throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
            }
            return x / y;
        }
    };

    private String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public abstract int calculate(int x, int y);

}
