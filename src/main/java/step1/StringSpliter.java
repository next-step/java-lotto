package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringSpliter {
    private final static String STRING_PATTERN = "//(.)\n(.*)";

    static String[] findCustomDelimiter(String input) {
        Matcher m = Pattern.compile(STRING_PATTERN).matcher(input);

        if (m.find()) {
            String customDelimiter = m.group(1);
            String inputs[] = m.group(2).split(customDelimiter);
            return inputs;
        }
        return input.split(UserInput.DELIMITER);
    }
}
