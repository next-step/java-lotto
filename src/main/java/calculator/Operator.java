package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", (a, b) -> a.value() + b.value()),
    SUBTRACT("-", (a, b) -> a.value() - b.value()),
    MULTIPLY("*", (a, b) -> a.value() * b.value()),
    DIVIDE("/", (a, b) -> a.value() / b.value())
    ;

    private final String sign;
    private final BiFunction<Operand, Operand, Integer> computeFunction;

    Operator(String sign, BiFunction<Operand, Operand, Integer> computeFunction) {
        this.sign = sign;
        this.computeFunction = computeFunction;
    }

    public static Operator from(String sign) {
        return Arrays.stream(Operator.values())
            .filter(op -> op.sign.equals(sign))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("잘못된 사칙연산 기호"));
    }

    public int compute(Operand left, Operand right) {
        return computeFunction.apply(left, right);
    }
}
