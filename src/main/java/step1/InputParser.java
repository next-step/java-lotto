package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int CUSTOM_DELIMITER_GROUP = 1;
    private static final int SPLIT_STRING_GROUP = 2;

    public static String[] parseInput(String input) {
        Matcher m = CUSTOM_PATTERN.matcher(input);

        if(m.find()) {
            String customDelimiter = m.group(CUSTOM_DELIMITER_GROUP);
            return m.group(SPLIT_STRING_GROUP).split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITER);
    }
}
