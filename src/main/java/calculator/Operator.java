package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (left, right) -> Operand.from(left + right)),
    MINUS("-", (left, right) -> Operand.from(left - right)),
    MULTIPLY("*", (left, right) -> Operand.from(left * right)),
    DIVIDE("/", (left, right) -> {
        if (right == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return Operand.from(left / right);
    });

    private String symbol;

    private BiFunction<Integer, Integer, Operand> operate;

    Operator(String operator, BiFunction<Integer, Integer, Operand> operate) {
        this.symbol = operator;
        this.operate = operate;
    }

    public Operand operate(int left, int right) {
        return this.operate.apply(left, right);
    }

    public static boolean isOperator(String token) {
        return Arrays
                .stream(values())
                .anyMatch(value -> value.symbol.equals(token));
    }

    public static Operator from(String symbol) {
        return Arrays.stream(values())
                .filter(value -> value.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 연산자입니다."));
    }

}
