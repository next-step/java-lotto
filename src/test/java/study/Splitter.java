package study;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    private static final String DEFAULT_SEPARATOR = "[,:]";
    private static final String PATTERN = "//(.)\n(.*)";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(PATTERN);
    private static final int MATCHER_CUSTOM_SEPARATOR_INDEX = 1;
    private static final int MATCHER_STRING_INDEX = 2;

    public static List<String> split(final String input) {
        Matcher customMatcher = CUSTOM_PATTERN.matcher(input);
        if (customMatcher.find()) {
            String customSeparator = customMatcher.group(MATCHER_CUSTOM_SEPARATOR_INDEX);
            return Arrays.asList(customMatcher.group(MATCHER_STRING_INDEX).split(customSeparator));
        }

        return Arrays.asList(input.split(DEFAULT_SEPARATOR));
    }
}
