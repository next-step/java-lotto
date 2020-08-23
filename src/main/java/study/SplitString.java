package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitString {
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final String STRING_DELIMITER = ",|:";

    private SplitString() {
    }

    public static String[] splitStringByDelimiter(String str) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(str);
        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }
        return str.split(STRING_DELIMITER);
    }
}
