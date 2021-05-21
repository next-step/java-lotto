package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
    public final static String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int GROUP_1 = 1;
    private static final int GROUP_2 = 2;

    public static String[] parse(String text) {
        Matcher matcher = CUSTOM_PATTERN.matcher(text);
        boolean isCustom = matcher.find();
        if (isCustom) {
            String customDelimiter = matcher.group(GROUP_1);
            return matcher.group(GROUP_2).split(customDelimiter);
        }
        return text.split(DEFAULT_DELIMITER);
    }
}

