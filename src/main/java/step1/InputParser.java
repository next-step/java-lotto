package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    private static final String CUSTOM_PATTERN = "//(.)\n(.*)";
    private static final String DEFAULT_DELIMITER = ",|:";

    public static String[] parseInput(String input) {
        Matcher m = Pattern.compile(CUSTOM_PATTERN).matcher(input);

        if(m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITER);
    }
}
