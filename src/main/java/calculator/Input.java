package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_DELIMITER = "[,:]";
    private String input;

    public Input(final String input) {
        this.input = input;
    }

    public Input() {}

    public boolean isEmpty() {
        return null == input || "".equals(input.trim());
    }

    String[] split() {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITER);
    }
}
