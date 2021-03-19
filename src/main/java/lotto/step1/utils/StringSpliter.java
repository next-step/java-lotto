package lotto.step1.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSpliter {

    private static final String TOKEN_DELIMITER = ",|:";
    private static final Pattern CUSTOM_PATTERN_REGEX = Pattern.compile("//(.)\n(.*)");

    private StringSpliter() {
    }

    public static String[] splitToStringArray(String input) {
        Matcher m = CUSTOM_PATTERN_REGEX.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return input.split(TOKEN_DELIMITER);
    }


}
