package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final int DEFAULT_SUM_VALUE = 0;
    private static final int CUSTOM_DELIMITER_GROUP_INDEX = 1;
    private static final int INPUT_REMOVED_CUSTOMER_DELIMITER_GROUP_INDEX = 2;
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final String OR = "|";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return DEFAULT_SUM_VALUE;
        }
        Numbers numbers = Numbers.of(extractNumbers(input));
        return numbers.sum();
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] extractNumbers(String input) {
        String delimiters = DEFAULT_DELIMITERS;
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_GROUP_INDEX);
            delimiters += OR + customDelimiter;
            input = matcher.group(INPUT_REMOVED_CUSTOMER_DELIMITER_GROUP_INDEX);
        }
        return input.split(delimiters);
    }
}
