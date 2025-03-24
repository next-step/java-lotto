package StringCalculator.domain;

import java.util.Arrays;
import java.util.List;

public class Expression {
    private static final String SPACE_DELIMITER = " ";

    private final String expression;

    public Expression(String expression) {
        checkValidate(expression);
        this.expression = expression;
    }

    public List<String> split() {
        return Arrays.asList(expression.split(SPACE_DELIMITER));
    }

    private void checkValidate(String expression) {
        if (expression == null) {
            throw new IllegalArgumentException("inputStr is null");
        }
        if (expression.isBlank()) {
            throw new IllegalArgumentException("inputStr is blank");
        }
    }
}
