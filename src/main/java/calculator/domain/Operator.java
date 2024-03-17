package calculator.domain;

import java.util.Arrays;

public enum Operator {
    PLUS("+") {
        @Override
        public int calculate(int operands1, int operands2) {
            return operands1 + operands2;
        }
    },
    MINUS("-") {
        @Override
        public int calculate(int operands1, int operands2) {
            return operands1 - operands2;
        }
    },
    MULTIPLY("*") {
        @Override
        public int calculate(int operands1, int operands2) {
            return operands1 * operands2;
        }
    },
    DIVIDE("/") {
        @Override
        public int calculate(int operands1, int operands2) {
            if (operands2 == 0) {
                throw new IllegalArgumentException("나누는 수로 0이 입력되었습니다.");
            }

            if (operands1 % operands2 != 0) {
                throw new IllegalArgumentException("나눗셈의 결과가 정수가 아닙니다.");
            }

            return operands1 / operands2;
        }
    };

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public abstract int calculate(int operands1, int operands2);

    public static Operator of(String symbol) {
        return Arrays.stream(values())
                .filter(operator -> operator.getSymbol().equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 연산자(+, -, *, /)를 입력하세요."));
    }
}
