package calculator.domain;

import java.util.Arrays;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVISION("/");

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public Number apply(Number leftOperand, Number rightOperand) {

        if (this == PLUS) {
            return leftOperand.plus(rightOperand);
        }
        if (this == MINUS) {
            return leftOperand.minus(rightOperand);
        }
        if (this == MULTIPLY) {
            return leftOperand.multiply(rightOperand);
        }
        return leftOperand.divide(rightOperand);
    }

    public static Operator fromSymbol(String symbol) {

        return Arrays.stream(Operator.values())
                .filter(op -> op.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 연산자가 아닙니다: " + symbol));
    }


    @Override
    public String toString() {
        return symbol;
    }
}
