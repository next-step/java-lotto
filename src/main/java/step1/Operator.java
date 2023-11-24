package step1;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", Integer::sum),
    SUBTRACT("-", Operator::subtract),
    MULTIPLE("*", Operator::multiple),
    DIVIDE("/", Operator::divide)
    ;

    private String symbol;

    private BiFunction<Integer, Integer, Integer> operate;

    Operator(final String symbol, final BiFunction<Integer, Integer, Integer> operate) {
        this.symbol = symbol;
        this.operate = operate;
    }

    private static Integer subtract(Integer a, Integer b) {
        return a - b;
    }

    private static Integer multiple(Integer a, Integer b) {
        return a * b;
    }

    private static Integer divide(Integer a, Integer b) {
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
                .orElseThrow(() -> { throw new IllegalArgumentException("사칙연산 기호가 아닙니다."); });
    }

}
