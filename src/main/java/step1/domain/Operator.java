package step1.domain;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (left, right) -> left + right),
    SUBTRACT("-", (left, right) -> left - right),
    MULTIPLY("*", (left, right) -> left * right),
    DIVIDE("/", (left, right) -> left / right);

    private String symbol;
    private BiFunction<Integer, Integer, Integer> biFunction;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> biFunction) {
        this.symbol = symbol;
        this.biFunction = biFunction;
    }

    public Integer calculate(int left, int right) {
        if (this == DIVIDE && right == 0) {
            throw new InvalidParameterException("0으로 나눌 수 없습니다.");
        }
        return biFunction.apply(left, right);
    }

    public static Operator toOperation(String symbol) {
        return Arrays.stream(values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findAny()
                .orElseThrow(() -> new InvalidParameterException("유효한 연산자가 아닙니다."));
    }
}
