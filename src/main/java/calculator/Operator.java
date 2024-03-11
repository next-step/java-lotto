package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", Integer::sum),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b)
    ;

    private final String sign;
    private final BiFunction<Integer, Integer, Integer> computeFunction;

    Operator(String sign, BiFunction<Integer, Integer, Integer> computeFunction) {
        this.sign = sign;
        this.computeFunction = computeFunction;
    }

    public static Operator from(String sign) {
        return Arrays.stream(Operator.values())
            .filter(op -> op.sign.equals(sign))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("잘못된 사칙연산 기호"));
    }

    public int compute(int left, int right) {
        return computeFunction.apply(left, right);
    }
}
