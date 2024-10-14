package calculator;

import java.util.Map;

public class Operators {

    private static final Map<String, Operator> operators = Map.of(
            "+", Integer::sum,
            "-", (left, right) -> left - right,
            "*", (left, right) -> left * right,
            "/", (left, right) -> left / right
    );

    public static Operator getOperator(String key) {
        if (operators.containsKey(key)) {
            return operators.get(key);
        }
        throw new IllegalArgumentException();
    }
}
