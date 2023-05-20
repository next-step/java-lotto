package stringcalculator;

import static stringcalculator.StringCalculator.ERRMSG_ONLY_NUMBERS_AND_OPERATORS_ALLOWED;

public enum Operator {
    ADDITION("+") {
        @Override
        public int apply(int result, int num) {
            return result + num;
        }
    },
    SUBTRACTION("-") {
        @Override
        public int apply(int result, int num) {
            return result - num;
        }
    },
    MULTIPLICATION("*") {
        @Override
        public int apply(int result, int num) {
            return result * num;
        }
    },
    DIVISION("/") {
        @Override
        public int apply(int result, int num) {
            return result / num;
        }
    };

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public abstract int apply(int result, int num);

    public static Operator fromSymbol(String symbol) {
        for (Operator operator : values()) {
            if (operator.symbol.equals(symbol)) {
                return operator;
            }
        }

        throw new IllegalArgumentException(ERRMSG_ONLY_NUMBERS_AND_OPERATORS_ALLOWED);
    }
}
