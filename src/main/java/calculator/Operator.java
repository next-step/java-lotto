package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (left, right) -> Operand.from(left.getValue() + right.getValue())),
    MINUS("-", (left, right) -> Operand.from(left.getValue() - right.getValue())),
    MULTIPLY("*", (left, right) -> Operand.from(left.getValue() * right.getValue())),
    DIVIDE("/", (left, right) -> {
        if (right.getValue() == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return Operand.from(left.getValue() / right.getValue());
    });

    private String symbol;

    private BiFunction<Operand, Operand, Operand> operate;

    Operator(String operator, BiFunction<Operand, Operand, Operand> operate) {
        this.symbol = operator;
        this.operate = operate;
    }

    public Operand operate(Operand left, Operand right) {
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
