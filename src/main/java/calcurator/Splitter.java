package calcurator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    private static final int PATTERN_SEPARATOR_INDEX = 1;
    private static final int PATTERN_SEPARATOR_INPUTS = 2;
    private static final String SYMBOL_COMMA_AND_COLON = ",|:";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static String[] split(String input) {
        Matcher matcher = CUSTOM_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(PATTERN_SEPARATOR_INDEX);
            return matcher.group(PATTERN_SEPARATOR_INPUTS).split(customDelimiter);
        }
        return input.split(SYMBOL_COMMA_AND_COLON);
    }
}
