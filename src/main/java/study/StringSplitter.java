package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {

    private static final String SPLIT_DELIMITER_REGEX = "[,:]";
    private static final Pattern CUSTOM_SPLIT_DELIMITER_REGEX = Pattern.compile("//(.)\\n(.*)");

    private StringSplitter() {}

    public static String[] split(String text) {
        Matcher matcher = CUSTOM_SPLIT_DELIMITER_REGEX.matcher(text);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return text.split(SPLIT_DELIMITER_REGEX);
    }
}
