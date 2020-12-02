package stringaddcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSeparator {

    private final static String CUSTOM_DELIMITER_PATTERN = "//(.)\\n(.*)";

    public String[] split(String input) {

        if (containsDelimiter(input)) {
            return Delimiter.split(input);
        }

        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return null;
    }

    private boolean containsDelimiter(String input) {
        return Delimiter.COMMA.hasDelimiter(input) || Delimiter.COLON.hasDelimiter(input);
    }

}
