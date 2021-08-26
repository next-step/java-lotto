package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_PATTERN = ",|:";
    private static final String CUSTOM_PATTERN = "//(.)\\n(.*)";

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
        Matcher m = Pattern.compile(CUSTOM_PATTERN).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return input.split(DEFAULT_PATTERN);
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
