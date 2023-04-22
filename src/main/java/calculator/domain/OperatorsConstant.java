package calculator.domain;

import static java.util.Arrays.stream;

import java.util.HashMap;
import java.util.Map;

public enum OperatorsConstant {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/")
    ;

    private static final Map<String, OperatorsConstant> OPERATORS_BY_SYMBOL = new HashMap<>();

    static {
        stream(OperatorsConstant.values())
                .forEach(operator -> OPERATORS_BY_SYMBOL.put(operator.symbol, operator));
    }

    private final String symbol;

    OperatorsConstant(String symbol) {
        this.symbol = symbol;
    }

    public static boolean isProperSymbol(String symbol) {
        return OPERATORS_BY_SYMBOL.containsKey(symbol);
    }
}
