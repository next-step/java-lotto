package calculator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitUtil {

    private static final String DELIMITER_REGEX = ",| |:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    private StringSplitUtil() {
    }

    public static String[] split(String expression) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(expression);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter + "|" + DELIMITER_REGEX);
        }

        return expression.split(DELIMITER_REGEX);
    }

}
