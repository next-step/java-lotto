package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {

    private static final String DEFAULT_DELIMITER = ",|\\:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    public String[] split(String text) {
        String delimiter = getMatchedDelimiter(text);
        return text.split(delimiter);
    }

    private String getMatchedDelimiter(String text) {
        String delimiter = "";
        if(text.matches(DEFAULT_DELIMITER)) {
            delimiter = getDelimiter(text, DEFAULT_DELIMITER, 0);
        }
        if(text.matches(CUSTOM_DELIMITER)) {
            delimiter = getDelimiter(text, CUSTOM_DELIMITER, 1);
        }
        return delimiter;
    }

    public String getDelimiter(String text, String delimiter, int index) {
        Matcher matcher = Pattern.compile(delimiter).matcher(text);
        if (matcher.find()) {
            return matcher.group(index);
        }
        throw new RuntimeException(Error.DELIMITER_NOT_EXIST);
    }
}
