package calculator.model;

import java.util.regex.Pattern;

public class ExpressionValidator {

    private static final String ERR_EMPTY_EXPRESSION = "Empty input values are not allowed.";
    private static final String ERR_INVALID_SYMBOL = "Only the following symbols can be used: +, -, *, /";

    public static void validate(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException(ERR_EMPTY_EXPRESSION);
        }

        if (containsInvalidSymbol(expression)) {
            throw new IllegalArgumentException(ERR_INVALID_SYMBOL);
        }
    }

    private static boolean containsInvalidSymbol(String expression) {
        return Pattern.compile("[^0-9+\\-*/]").matcher(expression).find();
    }
}
