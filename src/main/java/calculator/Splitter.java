package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    private static final String DEFAULT_REGEX = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final Pattern PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);

    public static String[] split(String str){
        Matcher m = PATTERN.matcher(str);
        if (m.find()) {
            String delimiter = m.group(1);
            return m.group(2).split(delimiter);
        }
        return str.split(DEFAULT_REGEX);
    }
}
