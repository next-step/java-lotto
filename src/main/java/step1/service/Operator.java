package step1.service;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BinaryOperator;

public enum Operator {

    PLUS("+", Integer::sum),
    SUBTRACT("-", Operator::subtract),
    MULTIPLE("*", Operator::multiple),
    DIVIDE("/", Operator::divide)
    ;

    private String symbol;

    private BinaryOperator<Integer> operate;

    Operator(final String symbol, final BinaryOperator<Integer> operate) {
        this.symbol = symbol;
        this.operate = operate;
    }

    private static int subtract(int a, int b) {
        return a - b;
    }

    private static int multiple(int a, int b) {
        return a * b;
    }

    private static int divide(int a, int b) {
        if (a % b != 0) {
            throw new IllegalArgumentException("나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정됩니다.");
        }
        return a / b;
    }

    public Integer calculate(Integer a, Integer b) {
        return operate.apply(a, b);
    }

    public static Operator of(final String symbol) {
        return Arrays.stream(values()).filter(a -> Objects.equals(a.symbol, symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호가 아닙니다."));
    }

}
