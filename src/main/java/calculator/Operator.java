package calculator;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", Integer::sum),
    MINUS("-", (a, b) -> a-b),
    MULTIPLY("*", (a, b) -> a*b),
    DIVIDE("/", (a, b) -> {
        if(a%b != 0){
            throw new IllegalArgumentException("나누어 떨어지는 값만 지원합니다");
        }
        return a/b;
    }),
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
