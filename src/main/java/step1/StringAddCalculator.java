package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final int BLANK_OUTPUT = 0;
    public static final int CONTINUE = -1;
    public static final String NEGATIVE_EXCEPTION_MESSAGE = "Negative number is not allowed";
    public static final String DEFAULT_DELIMITER = ",|:";

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
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isNegative(int operand) {
        if (operand < 0) {
            throw new IllegalArgumentException(NEGATIVE_EXCEPTION_MESSAGE);
        }
        return false;
    }

    public int plus(String[] operands) {
        int result = 0;

        for (String operand : operands) {
            int parsedOperand = Integer.parseInt(operand);

            if (!isNegative(parsedOperand)) {
                result += parsedOperand;
            }
        }

        return result;
    }

    public int plusByCustomDelimiter(String expression) {
        int DELIMITER_INDEX = 1;
        int OPERANDS_INDEX = 2;

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);

        if (m.find()) {
            String customDelimiter = m.group(DELIMITER_INDEX);
            String[] tokens = m.group(OPERANDS_INDEX).split(customDelimiter);

            return plus(tokens);
        }

        return CONTINUE;
    }

    public int plusByDefaultDelimiter(String expression) {
        String[] tokens = expression.split(DEFAULT_DELIMITER);

        return plus(tokens);
    }
}
