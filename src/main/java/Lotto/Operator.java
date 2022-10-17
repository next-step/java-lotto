package lotto;

import java.util.function.BiFunction;

public enum Operator {
    ADD("+", (num1, num2) -> num1 + num2),
    SUBTRACT("-", (num1, num2) -> num1 - num2),
    MULTIPLE("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private final String type;
    private final BiFunction<Integer, Integer, Integer> operate;

    Operator(String type, BiFunction<Integer, Integer, Integer> operate) {
        this.type = type;
        this.operate = operate;
    }

    public String type() {
        return type;
    }

    public int operate(int num1, int num2) {
        return operate.apply(num1, num2);
    }

    public static Operator operatorOf(String value) {
        if (value.equals(Operator.ADD.type())) return ADD;
        if (value.equals(Operator.SUBTRACT.type())) return SUBTRACT;
        if (value.equals(Operator.MULTIPLE.type())) return MULTIPLE;
        if (value.equals(Operator.DIVIDE.type())) return DIVIDE;

        throw new IllegalArgumentException("사칙연산이 아닙니다.");
    }
}
