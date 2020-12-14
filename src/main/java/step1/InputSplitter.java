package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputSplitter {

    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_PATTERN = ",|:";
    public static String[] split(String input) {
        Matcher matcher = CUSTOM_PATTERN.matcher(input);

        if(matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return input.split(DEFAULT_PATTERN);
    }
}
