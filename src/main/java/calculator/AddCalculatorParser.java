package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddCalculatorParser {

    private static final String DELIMITER = ",|:";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int[] split(String input) {
        Matcher matcher = CUSTOM_PATTERN.matcher(input);
        if (matcher.find()) {
            return split(matcher.group(2), createCustomDelimiter(matcher.group(1)));
        }

        return split(input, DELIMITER);
    }

    private static String createCustomDelimiter(String newDelimiter) {
        return String.join("|", DELIMITER, newDelimiter);
    }

    private static int[] split(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter))
            .mapToInt(Integer::valueOf)
            .toArray();
    }
}
