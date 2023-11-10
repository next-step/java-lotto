package step1;

import java.util.Arrays;

public enum OperationSymbol {

    PLUS("+"),
    MINUS("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private String symbol;

    OperationSymbol(String symbol) {
        this.symbol = symbol;
    }

    public static boolean isOperationSymbol(String symbol) {
        return Arrays.stream(OperationSymbol.values())
            .anyMatch(operationSymbol -> operationSymbol.symbol.equals(symbol));
    }
}
