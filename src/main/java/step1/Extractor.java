package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extractor {

    private static final String EXTRACT_DELIMITER_REGEX = "^//(.*?)\\n.*$";
    private static final String EXTRACT_NUMS_REGEX = "^//.*\\n(.*?)$";

    private static Pattern delimiterPattern  = Pattern.compile(EXTRACT_DELIMITER_REGEX);
    private static Pattern numsPattern = Pattern.compile(EXTRACT_NUMS_REGEX);

    public static String extractCustomDelimiter(String input) {
        return extract(
                delimiterPattern.matcher(input)
        );
    }

    public static String extractNums(String input) {
        return extract(
                numsPattern.matcher(input)
        );
    }

    private static String extract(Matcher matcher) {
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
