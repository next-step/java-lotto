package StringCalculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    DIVISION("/", (a, b) -> a / b),
    MULTIPLICATION("*", (a, b) -> a * b),
    UNKNOWN(null, null);

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> calculateFunc;

    Operator(String operator, BiFunction<Integer, Integer, Integer> calculateFunc) {
        this.operator = operator;
        this.calculateFunc = calculateFunc;
    }

    public Integer calculate(Integer a, Integer b) {
        return this.calculateFunc.apply(a, b);
    }

    public static Operator findOperator(String text) {
        return Arrays.stream(Operator.values())
                .filter(type -> type.operator != null)
                .filter(type -> text.contains(type.operator))
                .findFirst()
                .orElse(Operator.UNKNOWN);
    }

}
