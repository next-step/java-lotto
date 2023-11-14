package study.step1.domain.type;

import java.util.Arrays;
import java.util.function.BiFunction;

import study.step1.domain.exception.CalculatorException;

public enum Operator {

    PLUS("+", "더하기", (x, y) -> x + y),
    MINUS("-", "빼기", (x, y) -> x - y),
    TIMES("*", "곱하기", (x, y) -> x * y),
    DIVIDE("/", "나누기", (x, y) -> {
        if (y == 0) {
            throw new CalculatorException("DivideError: 0으로는 나눌 수 없습니다.");
        }
        return x / y;
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
