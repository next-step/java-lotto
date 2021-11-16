package addcalculator;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPlusCalculator {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int CUSTOM_DELIMITER = 1;
    private static final int MAIN_TEXT = 2;

    public static int execute(String text) {
        if (isNullAndEmpty(text)) {
            return 0;
        }

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            return plusNumbers(matcher);
        }

        return plusNumbers(StringSeparator.separate(text));
    }

    public static boolean isNullAndEmpty(String input) {
        return Objects.isNull(input) || input.isEmpty();
    }

    private static int plusNumbers(String[] stringNumbers) {
        return Arrays.stream(stringNumbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static int plusNumbers(Matcher matcher) {
        return plusNumbers(StringSeparator.separateFromCustomDelimiter(
                extractMainText(matcher),
                extractDelimiter(matcher)));
    }

    private static String extractDelimiter(Matcher matcher) {
        return matcher.group(CUSTOM_DELIMITER);
    }

    private static String extractMainText(Matcher matcher) {
        return matcher.group(MAIN_TEXT);
    }
}
