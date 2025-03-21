package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        if (b == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        if (a % b != 0) {
            throw new IllegalArgumentException("나누기 연산은 나누어 떨어져야 합니다.");
        }
        return a / b;
    }),
    START("", (a, b) -> {
        throw new IllegalArgumentException("START는 연산할 수 없습니다.");
    });

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> calculate;

    Operator(String operator, BiFunction<Integer, Integer, Integer> calculate) {
        this.operator = operator;
        this.calculate = calculate;
    }

    public static Operator of(String operator) {
        if (operator.length() != 1) {
            throw new IllegalArgumentException("연산자는 1자리여야 합니다.");
        }
        return Arrays.stream(Operator.values())
                .filter(o -> o.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연산자는 +, -, *, /만 가능합니다."));
    }

    public int calculate(int a, int b) {
        return calculate.apply(a, b);
    }
}
