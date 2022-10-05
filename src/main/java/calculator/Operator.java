package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", Operand::plus),
    MINUS("-", Operand::minus),
    MULTIPLY("*", Operand::multiply),
    DIVIDE("/", Operand::divide);

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
        for (Operator value : values()) {
            if (value.symbol.equals(symbol)) {
                return value;
            }
        }
        throw new IllegalArgumentException("잘못된 연산자입니다.");
    }

}
