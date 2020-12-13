package calculator.delimiter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringDelimiter {

    private static final String DEFAULT_DELIMITER_REGEX = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int PATTERN_MATCH_GROUP_1 = 1;
    private static final int PATTERN_MATCH_GROUP_2 = 2;

    private StringDelimiter() {
    }

    public static String[] splitByDelimiter(String text) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);

        if (matcher.find()) {
            String customDelimiter = matcher.group(PATTERN_MATCH_GROUP_1);
            return matcher.group(PATTERN_MATCH_GROUP_2).split(customDelimiter);
        }

        return text.split(DEFAULT_DELIMITER_REGEX);
    }
}
