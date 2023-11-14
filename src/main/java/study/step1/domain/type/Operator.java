package study.step1.domain.type;

import java.util.Arrays;
import java.util.function.BiFunction;

import study.step1.domain.DefaultOperation;

public enum Operator {

    PLUS("+", "더하기", (x, y) -> {
        DefaultOperation operation = new DefaultOperation();
        return operation.plus(x, y);
    }),
    MINUS("-", "빼기", (x, y) -> {
        DefaultOperation operation = new DefaultOperation();
        return operation.minus(x, y);
    }),
    TIMES("*", "곱하기", (x, y) -> {
        DefaultOperation operation = new DefaultOperation();
        return operation.times(x, y);
    }),
    DIVIDE("/", "나누기", (x, y) -> {
        DefaultOperation operation = new DefaultOperation();
        return operation.divide(x, y);
    });

    private final String code;
    private final String message;
    public final BiFunction<Integer, Integer, Integer> expression;

    public int calculate(int x, int y) {
        return expression.apply(x, y);
    }

    Operator(String code, String message, BiFunction<Integer, Integer, Integer> expression) {
        this.code = code;
        this.message = message;
        this.expression = expression;
    }

    public static Operator valueOfCode(String code) {
        return Arrays.stream(values())
            .filter(operator -> code.equals(operator.getCode()))
            .findAny()
            .orElse(null);
    }

    public String getCode() {
        return code;
    }
}
