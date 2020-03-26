package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_TOKEN_DELIMITER = ",|:";

    public static String[] split(String source) {
        Matcher matcher = CUSTOM_PATTERN.matcher(source);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return source.split(DEFAULT_TOKEN_DELIMITER);
    }
}
