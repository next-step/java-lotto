public enum Operators {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String symbol;

    Operators(String symbol) {
        this.symbol = symbol;
    }
}
