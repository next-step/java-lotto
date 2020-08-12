package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Splitter {
    private static final int DELIMITER_GROUP_INDEX = 1;
    private static final int TEXT_GROUP_INDEX = 2;
    private static final String REQUIREMENT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    private Splitter() {}

    public static String[] splitByDelimiter(String text) {
        Matcher matcher = CUSTOM_PATTERN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(DELIMITER_GROUP_INDEX);
            return matcher.group(TEXT_GROUP_INDEX).split(customDelimiter);
        }
        return text.split(REQUIREMENT_DELIMITER);
    }
}
