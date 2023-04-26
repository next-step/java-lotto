package calculator;

import java.util.List;

public class Expression {
    private static final String DELIMITER = " ";

    private Expression() {
    }

    public static List<String> parse(String expression) {
        validate(expression);

        return List.of(expression.split(DELIMITER));
    }

    private static void validate(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("input expression should be existed");
        }
    }
}
