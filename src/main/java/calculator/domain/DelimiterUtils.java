package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterUtils {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\n(.*)");
    private static final Pattern META_CHARACTERS = Pattern.compile("[\\\\\\]\\[(){}\\-!$?*+<>^\\|]");
    private static final String META_CHARACTER_SUPPORTER = "\\";
    private static final int DELIMITER_POSITION = 1;
    private static final int NUMBER_STRING_POSITION = 2;

    private DelimiterUtils() {
    }

    public static String findDelimiters(String input) {
        Matcher delimiterMatcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (delimiterMatcher.find()) {
            return checkMetaCharacter(delimiterMatcher.group(DELIMITER_POSITION));
        }

        return DEFAULT_DELIMITER;
    }

    public static String filterCustomDelimiter(String input) {
        Matcher delimiterMatcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (delimiterMatcher.find()) {
            return delimiterMatcher.group(NUMBER_STRING_POSITION);
        }

        return input;
    }

    private static String checkMetaCharacter(String delimiters) {
        if (META_CHARACTERS.matcher(delimiters).find()) {
            return META_CHARACTER_SUPPORTER + delimiters;
        }

        return delimiters;
    }

}
