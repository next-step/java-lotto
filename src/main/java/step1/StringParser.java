package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

    private static final String DEFAULT_DELIMITER = ";|,";
    private String input;

    public String setDelimiter(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            this.input = m.group(2);
            // 덧셈 구현
        return customDelimiter +"|"+DEFAULT_DELIMITER;
        }
        return DEFAULT_DELIMITER;
    }

    public String[] parse(String delimiter) {
        return this.input.split(delimiter);
    }
}
