package step1.domain;

import step1.exception.NotOperatorException;

import java.util.Arrays;

public enum Operator {

    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public static Operator of(String symbol) {
        return Arrays.stream(Operator.values())
            .filter(operator -> symbol.equals(operator.symbol))
            .findFirst()
            .orElseThrow(() -> new NotOperatorException());
    }

}
