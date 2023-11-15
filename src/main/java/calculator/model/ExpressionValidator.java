package calculator.model;

public class ExpressionValidator {

    private static final String ERR_EMPTY_EXPRESSION = "Empty input values are not allowed.";

    public static void validate(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException(ERR_EMPTY_EXPRESSION);
        }
    }
}
