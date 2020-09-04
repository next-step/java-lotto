package stringAddCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    private static final String BASIC_DELIMITER = ",|:";
    private static final Pattern CUSTOM_PATTERN =  Pattern.compile("//(.)\n(.*)");
    private static final int DELIMITER_GROUP = 1;
    private static final int NUMBERS_GROUP = 2;

    public static String[] split(String value) {
        Matcher matcher = CUSTOM_PATTERN.matcher(value);
        if (matcher.find()) {
            return splitByCustomDelimiter(matcher);
        }
        return value.split(BASIC_DELIMITER);
    }

    private static String[] splitByCustomDelimiter(Matcher matcher) {
        String customDelimiter = matcher.group(DELIMITER_GROUP);
        return matcher.group(NUMBERS_GROUP).split(customDelimiter);
    }
}
