package calculator;

import java.util.Arrays;

public enum OperatorType {
    ADD("+") {
        public int apply(int number1, int number2) {
            return number1 + number2;
        }
    },
    SUBTRACT("-") {
        public int apply(int number1, int number2) {
            return number1 - number2;
        }
    },
    MULTIPLY("*") {
        public int apply(int number1, int number2) {
            return number1 * number2;
        }
    },
    DIVIDE("/") {
        public int apply(int number1, int number2) {
            return number1 / number2;
        }
    };

    private final String symbol;

    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    public abstract int apply(int number1, int number2);

    public static OperatorType fromSymbol(String symbol) {
        return Arrays.stream(OperatorType.values())
                     .filter(operator -> operator.symbol.equals(symbol))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("Invalid operator: " + symbol));
    }
}
