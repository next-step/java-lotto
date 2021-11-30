package addcalculator;

import addcalculator.domain.Numbers;
import addcalculator.exception.NotInstanceException;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPlusCalculator {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int CUSTOM_DELIMITER = 1;
    private static final int MAIN_TEXT = 2;
    private static final int BASIC_RESULT_VALUE = 0;

    private StringPlusCalculator() {
        throw new NotInstanceException();
    }

    public static int execute(String text) {
        if (isNullAndEmpty(text)) {
            return BASIC_RESULT_VALUE;
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

    private static int plusNumbers(Numbers numbers) {
        return numbers.sum();
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
