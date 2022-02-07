package stringadder.utils;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringUtils {

    private static final String STANDARD_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final String SLASH = "//";
    private static final int SELECT_DELIMITER_INDEX = 1;
    private static final int SELECT_VALUES_INDEX = 2;

    private static final Pattern pattern;

    static {
        pattern = Pattern.compile(CUSTOM_DELIMITER);
    }

    private StringUtils() {

    }

    public static List<String> splitInput(final String input) {
        if (input.contains(SLASH)) {
            return Arrays.stream(split(input))
                .map(String::toString)
                .collect(Collectors.toList());
        }
        return Arrays.stream(input.split(STANDARD_DELIMITER)).map(String::toString)
            .collect(Collectors.toList());
    }

    private static String[] split(String input) {
        String[] tokens = null;
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(SELECT_DELIMITER_INDEX);
            tokens = matcher.group(SELECT_VALUES_INDEX).split(customDelimiter);
        }
        return tokens;
    }
}
