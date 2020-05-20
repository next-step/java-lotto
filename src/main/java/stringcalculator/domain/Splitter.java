package stringcalculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final Pattern PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    private Splitter() {
    }

    public static List<String> split(String expression) {
        Matcher customDelimiterMatcher = PATTERN.matcher(expression);

        if (customDelimiterMatcher.find()) {
            String delimiter = customDelimiterMatcher.group(1);
            String[] customSplits = customDelimiterMatcher.group(2).split(delimiter);
            return Arrays.asList(customSplits);
        }

        return Arrays.asList(expression.split(DEFAULT_DELIMITER));
    }
}
