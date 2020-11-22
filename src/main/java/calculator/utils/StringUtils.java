package calculator.utils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    private static final String REGEX_SEPARATOR = "//(.)\n(.*)";
    private static final String DEFAULT_SEPARATOR = ",|:";

    private StringUtils() {
    }

    public static List<String> splitString(String value) {
        Matcher matcher = Pattern.compile(REGEX_SEPARATOR).matcher(value);
        if (matcher.find()) {
            String separator = matcher.group(1);
            return Arrays.asList(matcher.group(2).split(separator));
        }
        return Arrays.asList(value.split(DEFAULT_SEPARATOR));
    }

    public static boolean isEmpty(String value) {
        return value == null || value.isEmpty() || value.equals(" ");
    }
}
