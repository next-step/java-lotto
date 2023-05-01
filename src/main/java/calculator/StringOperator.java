package calculator;

import java.util.Arrays;
import java.util.function.BinaryOperator;

enum StringOperator {
    ADD("+", (target, source) -> target + source),
    SUB("-", (target, source) -> target - source),
    DIV("/", (target, source) -> target / source),
    MUL("*", (target, source) -> target * source);

    private final String operator;
    private final BinaryOperator<Integer> binaryOperator;

    StringOperator(String operator, BinaryOperator<Integer> binaryOperator) {
        this.operator = operator;
        this.binaryOperator = binaryOperator;
    }

    public static StringOperator of(String operator) {
        return Arrays.stream(StringOperator.values())
                .filter(stringOperator -> stringOperator.is(operator))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(operator+"는 잘못된 연산자입니다."));
    }

    private boolean is(String operator) {
        return this.operator.equals(operator);
    }

    public Integer calc(int target, int source) {
        return this.binaryOperator.apply(target, source);
    }
}
