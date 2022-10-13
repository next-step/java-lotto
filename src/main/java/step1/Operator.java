package step1;

import java.util.Arrays;

public enum Operator {

    PLUS("+"),
    MINUS("-"),
    MULTIPLE("*"),
    DIVIDE("/");

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public static Operator of(String symbol) {
        return Arrays.stream(values())
            .filter(operator -> operator.symbol.equals(symbol))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("피연산자 기호가 아닙니다."));
    }
}
