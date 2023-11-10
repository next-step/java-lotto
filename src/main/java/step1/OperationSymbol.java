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

    public static boolean isPlus(String numAndSymbol) {
        return PLUS.symbol.equals(numAndSymbol);
    }

    public static boolean isMinus(String numAndSymbol) {
        return MINUS.symbol.equals(numAndSymbol);
    }

    public static boolean isMultiplication(String numAndSymbol) {
        return MULTIPLICATION.symbol.equals(numAndSymbol);
    }

    public static boolean isDivision(String numAndSymbol) {
        return DIVISION.symbol.equals(numAndSymbol);
    }
}
