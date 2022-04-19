package stringcalculator;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {

    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private String symbol;
    private BinaryOperator<Integer> binaryOperator;

    Operator(String symbol, BinaryOperator<Integer> binaryOperator) {
        this.symbol = symbol;
        this.binaryOperator = binaryOperator;
    }

    static Operator findBySymbol(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("invalid operator : " + symbol));
    }

    int apply(int operand1, int operand2) {
        if (this == DIVIDE && operand2 == 0) {
            throw new UnsupportedOperationException();
        }
        return binaryOperator.apply(operand1, operand2);
    }
}
