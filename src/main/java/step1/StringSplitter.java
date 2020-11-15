package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {
    private static final int FIRST_GROUP_MATCHER = 1;
    private static final int SECOND_GROUP_MATCHER = 2;
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final String STRING_DELIMITER = "[,:]";


    public static String[] splitStringByDelimiter(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(FIRST_GROUP_MATCHER);
            return matcher.group(SECOND_GROUP_MATCHER).split(customDelimiter);
        }
        return text.split(STRING_DELIMITER);
    }
}
