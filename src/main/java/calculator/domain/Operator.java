package calculator.domain;

import java.util.Arrays;

public enum Operator {
    PLUS("+") {
        @Override
        public int calculate(int operand1, int operand2) {
            return operand1 + operand2;
        }
    },
    MINUS("-") {
        @Override
        public int calculate(int operand1, int operand2) {
            return operand1 - operand2;
        }
    },
    MULTIPLY("*") {
        @Override
        public int calculate(int operand1, int operand2) {
            return operand1 * operand2;
        }
    },
    DIVIDE("/") {
        @Override
        public int calculate(int operand1, int operand2) {
            return operand1 / operand2;
        }
    };

    private final String value;

    Operator(String value) {
        this.value = value;
    }

    public static Operator of(String symbol) {
        return Arrays.stream(values())
                .filter(operator -> operator.value.equals(symbol))
                .findFirst()
                .orElseThrow();
    }

    public abstract int calculate(int operand1, int operand2);
}
