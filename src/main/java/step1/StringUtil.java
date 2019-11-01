package step1;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringUtil {
    private static final String REGEX_FOR_CUSTOM_DELIMITER = "//(.)\\\\n(.*)";
    private static final String DEFAULT_REGEX_DELIMITER = ":|,";
    private static final String REGEX_DELIMITER_WITH_CUSTOM_VALUE = ":|,|";

    public static boolean isNullOrEmpty(String input) {
        return input == null || input.equals("");
    }

    public static List<String> splitStrings(String input) {
        Matcher delimiterMatcher = Pattern.compile(REGEX_FOR_CUSTOM_DELIMITER).matcher(input);

        String delimiter = DEFAULT_REGEX_DELIMITER;
        if (delimiterMatcher.find()) {
            delimiter = REGEX_DELIMITER_WITH_CUSTOM_VALUE + delimiterMatcher.group(1);
            input = delimiterMatcher.group(2);
        }

        return Arrays.stream(input.trim()
                .split(delimiter))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
