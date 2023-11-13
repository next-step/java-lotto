package stringcalculator;

import java.util.Arrays;
import java.util.function.DoubleBinaryOperator;

public enum OperationSymbols {

    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLICATION("*", (a, b) -> a * b),
    DIVISION("/", (a, b) -> a / b);

    private final String symbol;
    private final DoubleBinaryOperator formula;

    OperationSymbols(String symbol, DoubleBinaryOperator formula) {
        this.symbol = symbol;
        this.formula = formula;
    }

    public static boolean isOperationSymbol(String symbol) {
        return Arrays.stream(OperationSymbols.values())
            .map(operationSymbol -> operationSymbol.symbol)
            .anyMatch(s -> s.equals(symbol));
    }

    public static DoubleBinaryOperator findFolmula(String symbol) {
        if (isPlus(symbol)) {
            return OperationSymbols.PLUS.formula;
        }

        if (isMinus(symbol)) {
            return OperationSymbols.MINUS.formula;
        }

        if (isMultiplication(symbol)) {
            return OperationSymbols.MULTIPLICATION.formula;
        }

        return OperationSymbols.DIVISION.formula;
    }

    private static boolean isPlus(String symbol) {
        return PLUS.symbol.equals(symbol);
    }

    private static boolean isMinus(String symbol) {
        return MINUS.symbol.equals(symbol);
    }

    private static boolean isMultiplication(String symbol) {
        return MULTIPLICATION.symbol.equals(symbol);
    }

    public static boolean isDivision(String symbol) {
        return DIVISION.symbol.equals(symbol);
    }
}