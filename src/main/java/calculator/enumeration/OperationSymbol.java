package calculator.enumeration;

import calculator.strategy.*;

import java.util.Arrays;
import java.util.Objects;

public enum OperationSymbol {
    ADDITION("+", Addition.getInstance()),
    SUBTRACTION("-", Subtraction.getInstance()),
    MULTIPLICATION("*", Multiplication.getInstance()),
    DIVISION("/", Division.getInstance()),
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
