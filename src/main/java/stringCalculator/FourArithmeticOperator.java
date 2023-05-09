package stringCalculator;

import java.util.Arrays;

public enum FourArithmeticOperator {
    PLUS("+") {
        @Override
        public int operate(Value value, int operand) {
            return value.add(operand);
        }
    },
    MINUS("-") {
        @Override
        public int operate(Value value, int operand) {
            return value.subtract(operand);
        }
    },
    MULTIPLY("*") {
        @Override
        public int operate(Value value, int operand) {
            return value.multiply(operand);
        }
    },
    DIVIDE("/") {
        @Override
        public int operate(Value value, int operand) {
            return value.divide(operand);
        }
    };

    private final String symbol;

    FourArithmeticOperator(String symbol) {
        this.symbol = symbol;
    }

    public static FourArithmeticOperator fromSymbol(String symbol) {
        return Arrays.stream(FourArithmeticOperator.values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findFirst()
                .orElse(null);
    }

    public abstract int operate(Value value, int operand);
}
