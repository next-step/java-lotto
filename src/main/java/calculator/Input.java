package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {

    private static String DEFAULT_DELIMITER = "[,:]";
    private String input;

    public Input(String input) {
        this.input = input;
    }

    public Input() {}

    public boolean isEmpty() {
        return null == input || "".equals(input.trim());
    }

    String[] split() {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITER);
    }
}
