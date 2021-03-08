package StringAddCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextSplitter {

    private static final String DEFAULT_DELIMITER = ",|:";

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    private static final int CUSTOM_DELIMITER_GROUP = 1;

    private static final int TEXT_GROUP = 2;

    public static String[] split(String text) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_GROUP);
            String extractedText = matcher.group(TEXT_GROUP);
            return splitBy(extractedText, customDelimiter);
        }
        return splitBy(text, DEFAULT_DELIMITER);
    }

    private static String[] splitBy(String text, String delimiter) {
        return text.split(delimiter);
    }

}
