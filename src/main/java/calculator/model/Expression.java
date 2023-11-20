package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Expression {
    private static final Pattern CONSECUTIVE_OPERATOR_PATTERN = Pattern.compile(".*[+\\-*/]{2,}.*");
    private static final String ERR_EMPTY_EXPRESSION = "Empty input values are not allowed.";
    private static final String ERR_CONSECUTIVE_OPERATORS = "Consecutive operators are not allowed.";
    private static final String ERR_STARTS_WITH_OPERATOR = "An operator cannot appear at the beginning of the expression.";
    private static final String ERR_ENDS_WITH_OPERATOR = "An operator cannot appear at the end of the expression.";
    private static final String ERR_INVALID_TOKENS = "The expression contains an invalid token. Only numbers and operators separated by spaces are allowed: ";

    public static void validate(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException(ERR_EMPTY_EXPRESSION);
        }

        List<String> tokens = splitByTokens(expression);
        if (isOperator(tokens.get(0))) {
            throw new IllegalArgumentException(ERR_STARTS_WITH_OPERATOR);
        }
        if (isOperator(tokens.get(tokens.size()-1))) {
            throw new IllegalArgumentException(ERR_ENDS_WITH_OPERATOR);
        }

        if (containsConsecutiveOperators(expression)) {
            throw new IllegalArgumentException(ERR_CONSECUTIVE_OPERATORS);
        }

        if (invalidTokens(tokens).size() != 0) {
            throw new IllegalArgumentException(ERR_INVALID_TOKENS + tokens);
        }

    }

    private static boolean containsConsecutiveOperators(String expression) {
        return CONSECUTIVE_OPERATOR_PATTERN.matcher(
                expression.replaceAll("\\s", "")
        ).matches();
    }

    public static boolean isNumber(String input) {
        return input.chars().allMatch( Character::isDigit );
    }

    public static boolean isOperator(String input) {
        try {
            Operator.getBySymbol(input);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static List<String> splitByTokens(String expression) {
        return Arrays.asList(expression.trim().split("\\s+"));
    }

    private static List<String> invalidTokens(List<String> tokens) {
        return tokens.stream()
                .filter(token -> !isNumber(token) && !isOperator(token))
                .collect(Collectors.toList());
    }
}
