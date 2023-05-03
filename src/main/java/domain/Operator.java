package domain;

public enum Operator {

    PLUS("+"),
    MINUS("-"),
    MULTIPLE("*"),
    DIVIDE("/");

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }
}
