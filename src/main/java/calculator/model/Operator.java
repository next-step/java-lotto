package calculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Operator {
    ADD("+"),
    SUB("-"),
    MUL("*"),
    DIV("/");

    private final String symbol;
    private static final String ERR_INVALID_SYMBOL = "Unsupported operator: ";
    private static final String ERR_UNSUPPORTED_OPERATION = "Operation not implemented for the entered symbol: ";

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public static Operator getBySymbol(String symbol) {
        return Arrays.stream(values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERR_INVALID_SYMBOL + symbol));
    }

    public int calculate(int leftNum, int rightNum) {
        if (this == Operator.ADD) {
            return add(leftNum, rightNum);
        }
        if (this == Operator.SUB) {
            return sub(leftNum, rightNum);
        }
        if (this == Operator.MUL) {
            return mul(leftNum, rightNum);
        }
        if (this == Operator.DIV) {
            return div(leftNum, rightNum);
        }
        throw new UnsupportedOperationException(ERR_UNSUPPORTED_OPERATION + this.toString());
    }

    private static int add(int left, int right) {
        return left + right;
    }

    private static int sub(int left, int right) {
        return left - right;
    }

    private static int mul(int left, int right) {
        return left * right;
    }

    private static int div(int left, int right) {
        return left / right;
    }

    @Override
    public String toString() {
        return this.symbol;
    }
}
