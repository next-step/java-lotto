package calculator;

import calculator.util.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public static final String DELIMITERS = ",|:";
    private static final String DELIMITER_SEPARATE_VALUE = "|";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    private final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);

    public String extractDelimiterFrom(String text) {
        Assert.notNull(text, "text는 null일 수 없습니다.");

        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return DELIMITERS + DELIMITER_SEPARATE_VALUE + matcher.group(1);
        }
        return DELIMITERS;
    }

    public String extractTextFrom(String text) {
        Assert.notNull(text, "text는 null일 수 없습니다.");

        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group(2);
        }
        return text;
    }

}
