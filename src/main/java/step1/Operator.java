package step1;

import java.util.Map;
import java.util.function.BiFunction;

public class Operator {
    private static final Map<String, BiFunction<Integer, Integer, Integer>> operators = Map.of(
            "+", (i1, i2) -> i1 + i2,
            "-", (i1, i2) -> i1 - i2,
            "*", (i1, i2) -> i1 * i2,
            "/", (i1, i2) -> i1 / i2
    );
    private final BiFunction<Integer, Integer, Integer> operator;

    public Operator(String token) {
        if (!operators.containsKey(token)) {
            throw new IllegalArgumentException();
        }
        operator = operators.get(token);
    }

    public static boolean isOperator(String token) {
        return operators.containsKey(token);
    }

    int calculate(int leftValue, int rightValue) {
        return operator.apply(leftValue, rightValue);
    }
}
