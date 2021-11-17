package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {

    private static final String STANDARD_REGEX = ",|:";
    private static final String CUSTOM_CHECK_REGEX = "//(.)\n(.*)";
    private static final String CUSTOM_REGEX = ",|:|\\%s";
    private static final int CUSTOM_DELIMITER_GROUP = 1;
    private static final int CUSTOM_EXPRESSION_GROUP = 2;

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
        String[] stringNumbers = input.split(STANDARD_REGEX);

        Matcher matcher = Pattern.compile(CUSTOM_CHECK_REGEX).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_GROUP);
            String regex = String.format(CUSTOM_REGEX, customDelimiter);
            stringNumbers = matcher.group(CUSTOM_EXPRESSION_GROUP).split(regex);
        }

        return stringNumbers;
    }

    public Number sum() {
        return numbers.sum();
    }
}
