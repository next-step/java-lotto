package calculator.model;

import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> function;

    Operator(String operator, BiFunction<Integer, Integer, Integer> function) {
        this.operator = operator;
        this.function = function;
    }

    public static int calculate(int a, String operator, int b) {
        return operator(operator).function.apply(a, b);
    }

    private static Operator operator(String operator) {
        Operator result = null;
        for (Operator o : values()) {
            if (o.operator.equals(operator)) {
                result = o;
            }
        }
        return result;
    }

}
