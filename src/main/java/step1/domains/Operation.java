package step1.domains;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operation {
    PLUS("+", (n, m) -> Calculator.plus(n, m)),
    MINUS("-", (n, m) -> Calculator.subtraction(n, m)),
    DIVIDE("/", (n, m) -> Calculator.divide(n, m)),
    MULTIPLY("*", (n, m) -> Calculator.multiply(n, m)),
    ;

    private String character;
    private BiFunction<Integer, Integer, Integer> expression;

    Operation(String character, BiFunction<Integer, Integer, Integer> expression) {
        this.character = character;
        this.expression = expression;
    }

    public int calculate(int n, int m) {
        return expression.apply(n, m);
    }

    public static Operation parse(String string) {
        return Arrays.stream(values())
                .filter(o -> o.character.equals(string))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
