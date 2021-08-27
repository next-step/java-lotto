package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER_PATTERN = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\\n(.*)";

    private static final int CUSTOM_DELIMITER_MATCHER_DELIMITER_INDEX = 1;
    private static final int CUSTOM_DELIMITER_MATCHER_ARRAY_INDEX = 2;

    private static final int DEFAULT_RESULT = 0;

    public StringAddCalculator() {
    }

    public int splitAndSum(String input) {
        if (isNullOrBlank(input)) {
            return DEFAULT_RESULT;
        }
        return sumValues(splitInput(input));
    }

    private String[] splitInput(String input) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(CUSTOM_DELIMITER_MATCHER_DELIMITER_INDEX);
            return m.group(CUSTOM_DELIMITER_MATCHER_ARRAY_INDEX).split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITER_PATTERN);
    }

    private boolean isNullOrBlank(String input) {
        return input == null || input.trim().isEmpty();
    }

    private int sumValues(String[] input) {
        return Arrays.stream(input)
            .map(Number::new)
            .mapToInt(Number::number)
            .sum();
    }

}
