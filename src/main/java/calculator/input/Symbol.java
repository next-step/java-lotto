package calculator.input;

import java.util.Map;

public class Symbol {

    private static final Map<String, Symbol> CACHE_MAP_SYMBOL;

    static {
        CACHE_MAP_SYMBOL = Map.of(
                "+", new Symbol("+"),
                "-", new Symbol("-"),
                "*", new Symbol("*"),
                "/", new Symbol("/")
        );
    }

    private final String symbol;

    public Symbol(final String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Symbol fromSymbol(String symbol) {
        if (symbol == null || symbol.isEmpty()) {
            throw new IllegalArgumentException("기호에 빈 값이 존재합니다.");
        }

        if (!CACHE_MAP_SYMBOL.containsKey(symbol)) {
            throw new IllegalArgumentException("연산 가능한 기호가 아닙니다.");
        }

        return CACHE_MAP_SYMBOL.get(symbol);
    }

}
