package study;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    private static final String DELIMITER = "[,:]";
    private static final String PATTERN = "//(.)\n(.*)";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(PATTERN);
    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int MATCHER_STRING_INDEX = 2;

    protected static List<String> split(String string) {
        Matcher matcher = CUSTOM_PATTERN.matcher(string);
        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_INDEX);
            return Arrays.asList(matcher.group(MATCHER_STRING_INDEX).split(customDelimiter));
        }
        return Arrays.asList(string.split(DELIMITER));
    }
}
