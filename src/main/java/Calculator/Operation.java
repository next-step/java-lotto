package Calculator;

import java.util.Arrays;

public enum Operation {
    ADD("+") {
        @Override
        public int apply(final int num1, final int num2) {
            return num1 + num2;
        }
    },
    MINUS("-") {
        @Override
        public int apply(int num1, int num2) {
            return num1 - num2;
        }
    },
    DIVISION("/"){
        @Override
        public int apply(int num1, int num2) {
            if (num2 == 0)
                throw new IllegalArgumentException("0으로는 나눌수 없습니다");
            return num1 / num2;
        }
    },
    MULTIPLY("*") {
        @Override
        public int apply(int num1, int num2) {
            return num1 * num2;
        }
    };

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public static Operation of(final String symbol) {
        return Arrays.stream(values())
                .filter(operator -> operator.isTextOperator(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 연산자를 찾을수 없습니다."));
    }

    private boolean isTextOperator(String symbol) {
        return this.symbol.equals(symbol);
    }

    public abstract int apply(int num1, int num2);
}
