package step1.domains;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operation {
    PLUS("+", Calculator::plus),
    MINUS("-", Calculator::subtraction),
    DIVIDE("/", Calculator::divide),
    MULTIPLY("*", Calculator::multiply),
    ;

    private final String character;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operation(String character, BiFunction<Integer, Integer, Integer> expression) {
        this.character = character;
        this.expression = expression;
    }

    public int calculate(int n, int m) {
        return expression.apply(n, m);
    }

    public static Operation find(String string) {
        return Arrays.stream(values())
                .filter(o -> o.character.equals(string))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
