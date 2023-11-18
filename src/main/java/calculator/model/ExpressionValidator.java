package calculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ExpressionValidator {
    private static final String ERR_EMPTY_EXPRESSION = "Empty input values are not allowed.";
    private static final String ERR_INVALID_SYMBOL = "Only the following symbols can be used: " + Operator.getAllSymbols();
    private static final String ERR_INVALID_EXPRESSION = "Expression is not valid.";

    public static void validate(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException(ERR_EMPTY_EXPRESSION);
        }

        if (containsInvalidSymbol(expression) || containsConsecutiveOperators(expression)) {
            throw new IllegalArgumentException(ERR_INVALID_SYMBOL);
        }

        if (!checkNumberOnEdge(expression)) {
            throw new IllegalArgumentException(ERR_INVALID_EXPRESSION);
        }
    }

    private static boolean containsInvalidSymbol(String expression) {
        String regex = "^[0-9+\\-*/\\s]*$";
        return !Pattern.matches(regex, expression);
    }

    private static boolean checkNumberOnEdge(String expression) {
        expression = expression.trim();
        if ((Pattern.matches("^\\d.*", expression)
                || Pattern.matches("^-\\d.*", expression))
                && Pattern.matches(".*\\d$", expression)) {
            return true;
        }
        return false;
    }

    private static boolean containsConsecutiveOperators(String expression) {
        String regex = ".*[+\\-*/]{2,}.*";
        return Pattern.matches(regex, expression.replaceAll("\\s", ""));
    }
}
