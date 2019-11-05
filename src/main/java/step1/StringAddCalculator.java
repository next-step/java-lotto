package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int BLANK_OUTPUT = 0;
    private static final String NEGATIVE_EXCEPTION_MESSAGE = "Negative number is not allowed";
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    private String expression;

    public StringAddCalculator() {

    }

    int calculate(String input) {
        this.expression = input;

        if (isBlank()) {
            return BLANK_OUTPUT;
        }

        if (isNumeric()) {
            return Integer.parseInt(expression);
        }

        if(isCustomDelimiter()) {
            return plusByCustomDelimiter();
        }

        return plusByDefaultDelimiter();
    }

    public boolean isBlank() {
        if (expression == null || expression.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isNumeric() {
        try {
            Double.parseDouble(expression);
            return true;
        } catch (NumberFormatException ignored) {
            return false;
        }
    }

    private boolean isCustomDelimiter() {
        return getMatcher(CUSTOM_DELIMITER_PATTERN).find();
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

    public int plusByCustomDelimiter() {
        int DELIMITER_INDEX = 1;
        int OPERANDS_INDEX = 2;

        Matcher customDelimiterMatcher = getMatcher(CUSTOM_DELIMITER_PATTERN);

        customDelimiterMatcher.find();
        String customDelimiter = customDelimiterMatcher.group(DELIMITER_INDEX);
        String[] tokens = customDelimiterMatcher.group(OPERANDS_INDEX).split(customDelimiter);

        return plus(tokens);
    }

    private Matcher getMatcher(Pattern pattern) {
        return pattern.matcher(expression);
    }

    public int plusByDefaultDelimiter() {
        String[] tokens = expression.split(DEFAULT_DELIMITER);

        return plus(tokens);
    }
}
