package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Arrays.asList;

public class StringUtils {
    public static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final String NUMBER = "[+-]?\\d*(\\.\\d+)?";

    public static final int MATCHED_DELIMITER = 1;
    public static final int MATCHED_NUMBERS = 2;

    private static final Pattern PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    public static List<String> split(String input) {
        Matcher matcher = PATTERN.matcher(input);

        if (matcher.find()) {
            String customDelimiter = matcher.group(MATCHED_DELIMITER);
            String numbers = matcher.group(MATCHED_NUMBERS);

            return asList(numbers.split(customDelimiter));
        }

        return asList(input.split(DEFAULT_DELIMITER));
    }

    public static boolean isNumber(String input) {
        return input.matches(NUMBER);
    }
}
