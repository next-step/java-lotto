package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {

    private static final String STANDARD_REGEX = ",|:";
    private static final String CUSTOM_CHECK_REGEX = "//(.)\n(.*)";
    private static final String CUSTOM_REGEX = ",|:|\\%s";
    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int CUSTOM_EXPRESSION_INDEX = 2;

    private Numbers numbers;

    public Expression(final String input) {
        numbers = new Numbers();
        if (isNotEmpty(input)) {
            String[] stringNumbers = generateStringNumbers(input);
            numbers = new Numbers(stringNumbers);
        }
    }

    private boolean isNotEmpty(String input) {
        return (input != null) && (!input.isEmpty());
    }

    private String[] generateStringNumbers(String input) {
        String[] stringNums = input.split(STANDARD_REGEX);

        Matcher matcher = Pattern.compile(CUSTOM_CHECK_REGEX).matcher(input);
        if (matcher.find()) {
            String customDelim = matcher.group(CUSTOM_DELIMITER_INDEX);
            String regex = String.format(CUSTOM_REGEX, customDelim);
            stringNums = matcher.group(CUSTOM_EXPRESSION_INDEX).split(regex);
        }

        return stringNums;
    }

    public boolean hasNextNumber() {
        return !numbers.isEmpty();
    }

    public Number nextNumber() {
        return numbers.nextNumber();
    }
}
