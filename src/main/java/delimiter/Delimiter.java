package delimiter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {

    public static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    public static String[] splitByDelimiter(String text) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);
        if(m.find()) {
            String customDelimeter = m.group(1);
            return m.group(2).split(customDelimeter);
        }
        return text.split(",|:");
    }
}
