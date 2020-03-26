package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_TOKEN_DELIMITER = "[,:]";
    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int SPLIT_TARGET_INDEX = 2;

    public static String[] split(String source) {
        Matcher matcher = CUSTOM_PATTERN.matcher(source);
        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_INDEX);
            return matcher.group(SPLIT_TARGET_INDEX).split(customDelimiter);
        }
        return source.split(DEFAULT_TOKEN_DELIMITER);
    }
}
