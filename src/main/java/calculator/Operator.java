package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", Integer::sum),
    MINUS("-", (a,b) -> a - b),
    MULTIPLY("*", (a,b) -> a * b),
    DIVIDE("/", (a,b) -> a / b),
    ;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> operateFunction) {
        this.symbol = symbol;
        this.operateFunction = operateFunction;
    }

    private static final Map<String, Operator> OPERATORS = new HashMap<>();

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> operateFunction;

    static {
        for (Operator operator : Operator.values())
            OPERATORS.put(operator.symbol, operator);
    }

    public static Operator valueOfSymbol(String symbol) {
        return OPERATORS.get(symbol);
    }

    public Integer calculate(Integer a, Integer b) {
        return operateFunction.apply(a, b);
    }
}
