package calculator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private String operatorStr;
    private BiFunction<Integer, Integer, Integer> expression;

    Operator(String operatorStr, BiFunction<Integer, Integer, Integer> expression) {
        this.operatorStr = operatorStr;
        this.expression = expression;
    }

    public String getOperatorStr() {
        return operatorStr;
    }

    public static Operator getOperatorByStr(String operatorStr) {
        return Arrays.stream(values())
                .filter(x -> operatorStr.equals(x.getOperatorStr()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산 기호가 아닙니다."));
    }

    public int calculate(int x, int y) {
        return expression.apply(x, y);
    }
}
