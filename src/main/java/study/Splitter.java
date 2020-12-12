package study;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    private final static String DELIMITER = "[,:]";
    private final static String PATTERN = "//(.)\n(.*)";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(PATTERN);
    private final static int CUSTOM_DELIMITER_INDEX = 1;
    private final static int MATCHER_STRING_INDEX = 2;

    static List<String> split(String string) {
        Matcher matcher = CUSTOM_PATTERN.matcher(string);
        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_INDEX);
            return Arrays.asList(matcher.group(MATCHER_STRING_INDEX).split(customDelimiter));
        }
        return Arrays.asList(string.split(DELIMITER));
    }
}
