package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdditionExpression {
    public static final String DEFAULT = ",|:";
    public static final String CUSTOM_PREFIX = "//";
    public static final String CUSTOM_SUFFIX = "\n";
    public static final Pattern CUSTOM_PATTERN = Pattern.compile(
            CUSTOM_PREFIX + "(.*?)" + CUSTOM_SUFFIX);
    private final String input;
    private String separator = DEFAULT;

    public StringAdditionExpression(String input) {
        Matcher matcher = CUSTOM_PATTERN.matcher(input);
        if (matcher.find()) {
            this.separator = matcher.group(1);
        }
        this.input = input;
    }
}
