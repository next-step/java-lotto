package sequenceCalculator;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", Integer::sum),

    MINUS("-", (a, b) -> a - b),

    MULTIPLY("*", (a, b) -> a * b),

    DIVIDE("/", (a, b) -> a / b);

    private String sign;
    private BiFunction<Integer, Integer, Integer> function;

    Operator(String sign) {
        this.sign = sign;
    }

    Operator(String sign, BiFunction<Integer, Integer, Integer> function) {
        this.sign = sign;
        this.function = function;
    }

    public int calculate(int current, int target) {
        return function.apply(current, target);
    }

    public String getSign() {
        return sign;
    }

    public static Operator findOperator(String sign) {
        return Arrays.stream(Operator.values())
            .filter(operator -> Objects.equals(operator.getSign(), sign))
            .findAny()
            .orElseThrow(() -> {
                throw new IllegalArgumentException("사칙연산이 아닌 문자입니다.");
            });
    }

}
