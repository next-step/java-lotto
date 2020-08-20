package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumericalExpression {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final Pattern DEFAULT_PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    private final String text;

    public NumericalExpression(String text) {
        this.text = text;
    }

    public String[] split() {
        Matcher m = DEFAULT_PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(DEFAULT_DELIMITER);
    }

}
