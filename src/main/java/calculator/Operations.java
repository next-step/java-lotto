package calculator;

import calculator.operations.*;

public enum Operations {
    PLUS(new Plus(), Plus.symbol),
    MINUS(new Minus(), Minus.symbol),
    MULTIPLY(new Multiply(), Multiply.symbol),
    DIVIDE(new Divide(), Divide.symbol);

    private final Operator operator;
    private final String symbol;

    Operations(Operator operator, String symbol) {
        this.operator = operator;
        this.symbol = symbol;
    }

    public int apply(int a, int b) {
        return operator.apply(a, b);
    }

    public boolean equals(String input) {
        return symbol.equals(input);
    }
}

