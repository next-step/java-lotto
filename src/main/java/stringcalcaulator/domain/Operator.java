package stringcalcaulator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", Integer::sum),
    SUB("-", (left, right) -> left - right),
    MUL("*", (left, right) -> left * right),
    DIV("/", (left, right) -> left / right),
    ;

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> operation;

    public static Operator from(String token) {
        return Arrays.stream(Operator.values())
            .filter(operatorToken -> operatorToken.isMatchSymbol(token))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("해당 연산자를 찾을 수 없습니다."));
    }

    private boolean isMatchSymbol(String symbol) {
        return this.symbol.equals(symbol);
    }

    Operator(String symbol, BiFunction<Integer, Integer, Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public int calculate(int left, int right) {
        return operation.apply(left, right);
    }
}
