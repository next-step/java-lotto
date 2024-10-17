package calculator.enumeration;

import calculator.strategy.*;

import java.util.Arrays;
import java.util.Objects;

public enum OperationSymbol {
    ADDITION("+", (left, right) -> left + right),
    SUBTRACTION("-", (left, right) -> left - right),
    MULTIPLICATION("*", (left, right) -> left * right),
    DIVISION("/", (left, right) -> left / right),
    ;

    private final String symbol;
    private final OperationStrategy operationStrategy;

    OperationSymbol(final String symbol, final OperationStrategy operationStrategy) {
        this.symbol = symbol;
        this.operationStrategy = operationStrategy;
    }

    public static OperationSymbol from(final String symbol) {
        return Arrays.stream(values())
                .filter(operationSymbol -> Objects.equals(operationSymbol.symbol, symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid symbol: " + symbol));
    }

    public int calculate(final int left, final int right) {
        return this.operationStrategy.calculate(left, right);
    }
}
