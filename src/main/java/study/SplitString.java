package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitString {
    private static final int INDEX_OF_FIRST_GROUP_MATCHER = 1;
    private static final int INDEX_OF_SECOND_GROUP_MATCHER = 2;
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final String STRING_DELIMITER = ",|:";

    private SplitString() {
    }

    public static String[] splitStringByDelimiter(String str) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(str);
        if (matcher.find()) {
            return matcher.group(INDEX_OF_SECOND_GROUP_MATCHER)
                    .split(matcher.group(INDEX_OF_FIRST_GROUP_MATCHER));
        }
        return str.split(STRING_DELIMITER);
    }
}
