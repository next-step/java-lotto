package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int BLANK_OUTPUT = 0;
    private static final int CONTINUE = -1;
    private static final String NEGATIVE_EXCEPTION_MESSAGE = "Negative number is not allowed";
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    private String expression;

    public StringAddCalculator(String input) {
        this.expression = input;
    }

    int calculate() {
        if (isBlank(expression)) {
            return BLANK_OUTPUT;
        }

        if (isNumeric(expression)) {
            return Integer.parseInt(expression);
        }

        int result = plusByCustomDelimiter(expression);
        if (result != CONTINUE) {
            return result;
        }

        return plusByDefaultDelimiter(expression);
    }

    public boolean isBlank(String expression) {
        if (expression == null || expression.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isNumeric(String expression) {
        try {
            Double.parseDouble(expression);
            return true;
        } catch (NumberFormatException ignored) {
            return false;
        }
    }

    public void checkNegative(int operand) {
        if (operand < 0) {
            throw new IllegalArgumentException(NEGATIVE_EXCEPTION_MESSAGE);
        }
    }

    public int plus(String[] operands) {
        int result = 0;

        for (String operand : operands) {
            int parsedOperand = Integer.parseInt(operand);

            checkNegative(parsedOperand);
            result += parsedOperand;
        }

        return result;
    }

    public int plusByCustomDelimiter(String expression) {
        int DELIMITER_INDEX = 1;
        int OPERANDS_INDEX = 2;

        Matcher customDelimiterMatcher = getMatcher(expression, CUSTOM_DELIMITER_PATTERN);

        if (customDelimiterMatcher.find()) {
            String customDelimiter = customDelimiterMatcher.group(DELIMITER_INDEX);
            String[] tokens = customDelimiterMatcher.group(OPERANDS_INDEX).split(customDelimiter);

            return plus(tokens);
        }

        return CONTINUE;
    }

    private Matcher getMatcher(String expression, Pattern pattern) {
        return pattern.matcher(expression);
    }

    public int plusByDefaultDelimiter(String expression) {
        String[] tokens = expression.split(DEFAULT_DELIMITER);

        return plus(tokens);
    }
}
