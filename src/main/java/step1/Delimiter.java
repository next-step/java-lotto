package step1;

import java.util.Objects;

public class Delimiter {

    private static final String DEFAULT_DELIMITER = ":|,";
    private static final String ADD_FORMAT = "%s|%s";
    private static final String EMPTY_SYMBOL = "";

    private final String symbol;

    private Delimiter(String symbol) {
        this.symbol = symbol;
    }

    public static Delimiter withDefaultDelimiter() {
        return new Delimiter(DEFAULT_DELIMITER);
    }

    public static Delimiter custom(String symbol) {
        if(symbol == null) {
            symbol = EMPTY_SYMBOL;
        }
        return new Delimiter(symbol);
    }

    public boolean isExist() {
        return this.symbol != null && this.symbol.isEmpty() != true;
    }

    public Delimiter addDelimiter(Delimiter other) {
        return new Delimiter(String.format(ADD_FORMAT, this.symbol, other.getSymbol()));
    }

    public String getSymbol() {
        return this.symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delimiter delimiter1 = (Delimiter) o;
        return Objects.equals(symbol, delimiter1.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }

    @Override
    public String toString() {
        return "Delimiter{" +
                "delimiter='" + symbol + '\'' +
                '}';
    }

}
