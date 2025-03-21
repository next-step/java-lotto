import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String symbol;
    private static final Map<String, Operator> SYMBOL_MAP = Stream.of(values()).collect(Collectors.toMap(Operator::getSymbol, op -> op));

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Operator fromSymbol(String symbol) {
        Operator operator = SYMBOL_MAP.get(symbol);
        if (operator == null) {
            throw new IllegalArgumentException("Unknown operator: " + symbol);
        }
        return operator;
    }
}
