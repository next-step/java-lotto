package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {

    private static final String COMMA_DELIMITER = ",";
    private static final String COLON_DELIMITER = ":";
    private static final String DEFAULT_DELIMITER_REGEX = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    public String[] split(String text) {
        return getSplitText(text);
    }

    private String[] getSplitText(String text) {
        if(text.contains(COLON_DELIMITER) || text.contains(COMMA_DELIMITER)) {
            return getDefaultSplitText(text);
        }
        if(text.matches(CUSTOM_DELIMITER_REGEX)) {
            return getCustomSplitText(text);
        }
        throw new RuntimeException(Error.DELIMITER_NOT_EXIST);
    }

    public String[] getDefaultSplitText(String text) {
        return text.split(DEFAULT_DELIMITER_REGEX);
    }

    public String[] getCustomSplitText(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);
        if (matcher.find()) {
            String delimiter =  matcher.group(1);
            return matcher.group(2).split(delimiter);
        }
        throw new RuntimeException(Error.DELIMITER_NOT_EXIST);
    }
}
