package domain;

public enum Operator {

    PLUS("+"),
    MINUS("-"),
    MULTIPLE("*"),
    DIVIDE("/");

    private final String symbol;
    private final static int ZERO = 0;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    private static int devide(int first, int second) {
        return 0;
    }
}
