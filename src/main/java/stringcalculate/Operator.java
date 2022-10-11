package stringcalculate;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", (a, b) -> (a + b)),
    SUBTRACT("-", (a, b) -> (a - b)),
    MULTIPLY("*", (a, b) -> (a * b)),
    DIVIDE("/", (a, b) -> (a / b));
    private final String operator;
    private final BiFunction<Integer, Integer, Integer> biFunction;

    Operator(String operator, BiFunction<Integer, Integer, Integer> biFunction) {
        this.operator = operator;
        this.biFunction = biFunction;
    }

    public static Integer calculate(Integer a, String iOperator, Integer b) {
        return getOperator(iOperator).biFunction.apply(a, b);
    }

    private static Operator getOperator(String input) {
        return Arrays.stream(values())
                .filter(o -> input.equals(o.operator))
                .findFirst()
                .orElseThrow(() -> new WrongInputException("올바른 연산자가 없습니다."));
    }
}
