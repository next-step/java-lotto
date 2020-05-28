package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_REGEX = Pattern.compile("//(.*)\n(.*)");

    public String[] parse(String text) {
        Matcher m = CUSTOM_DELIMITER_REGEX.matcher(text);
        if (m.find()) {
            String delimiter = m.group(1);
            return m.group(2).split(delimiter);
        }

        return text.split(DEFAULT_DELIMITER_REGEX);
    }
}
