package stringadder.utils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringUtils {

    private static final String STANDARD_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final String SLASH = "//";

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
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(input);
        String[] tokens = null;
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            tokens = matcher.group(2).split(customDelimiter);
        }
        return tokens;
    }
}
