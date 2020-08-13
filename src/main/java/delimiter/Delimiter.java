package delimiter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {

    public static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    public static String[] splitByDefaultDelimiter(String text) {
        return text.split(",|:");
    }

    public static String[] splitByCustomDelimiter(String text) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);
        String[] texts = null;
        if(m.find()) {
            String customDelimeter = m.group(1);
            texts = m.group(2).split(customDelimeter);
        }
        return texts;
    }
}
