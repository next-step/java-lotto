package calculator.delimiter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringDelimiter {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    public static final String DEFAULT_DELIMITER_REGEX = ",|:";

    public static String[] splitByDelimiter(String text) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if(m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(DEFAULT_DELIMITER_REGEX);
    }
}
