package calculator;


public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVISION("/");

    public final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }
}
