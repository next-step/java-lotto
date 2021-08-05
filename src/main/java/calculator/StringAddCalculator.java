package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n(.*)");
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final int NUMBERS_JOINED_BY_DELIMITER_GROUP = 2;
    private static final int CUSTOM_DELIMITER_GROUP = 1;

    public int calculate(String input) {
        return Arrays.stream(parse(input))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private String[] parse(String input) {
        Matcher customDelimiterMatcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (customDelimiterMatcher.find()) {
            return parseWithCustomDelimiter(customDelimiterMatcher);
        }
        return input.split(DEFAULT_DELIMITER_REGEX);
    }

    private String[] parseWithCustomDelimiter(Matcher customDelimiterMatcher) {
        return getNumbersJoinedByDelimiter(customDelimiterMatcher)
                    .split(getCustomDelimiter(customDelimiterMatcher));
    }

    private String getNumbersJoinedByDelimiter(Matcher customDelimiterMatcher) {
        return customDelimiterMatcher.group(NUMBERS_JOINED_BY_DELIMITER_GROUP);
    }

    private String getCustomDelimiter(Matcher customDelimiterMatcher) {
        return Pattern.quote(customDelimiterMatcher.group(CUSTOM_DELIMITER_GROUP));
    }

}
