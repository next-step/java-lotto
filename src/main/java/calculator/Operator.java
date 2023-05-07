package calculator;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", Integer::sum),
    MINUS("-", Integer::sum),
    MULTIPLY("*", Integer::sum),
    DIVIDE("/", Integer::sum),
    ;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> function) {
        this.symbol = symbol;
        this.function = function;
    }

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> function;


    public static Operator find(String symbol){
        return Arrays.stream(Operator.values())
                .filter(operator -> Objects.equals(operator.symbol, symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("not support operator "+symbol));
    }

    public int calculate(int a, int b){
        return function.apply(a, b);
    }
}
