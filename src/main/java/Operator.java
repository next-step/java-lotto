import java.util.Arrays;

public enum Operator {
    ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVIDE("/");

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public static Operator valueOfSymbol(String symbol) {
        return Arrays.stream(values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}