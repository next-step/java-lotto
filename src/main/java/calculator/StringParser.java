package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
    public final static String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static String[] parse(String text) {
        Matcher matcher = CUSTOM_PATTERN.matcher(text);
        boolean isCustom = matcher.find();
        if (isCustom) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return text.split(DEFAULT_DELIMITER);
    }
}

