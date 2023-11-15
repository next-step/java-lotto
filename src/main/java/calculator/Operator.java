package calculator;

import java.util.Arrays;

public enum Operator {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String symbol;
    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String symbol() {
        return symbol;
    }

    public static Operator findSymbol(String character) {
        return Arrays.stream(Operator.values())
                .filter(operator ->  operator.symbol.equals(character)).findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
