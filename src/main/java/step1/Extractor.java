package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extractor {
    private Extractor() {}

    private static final String BAD_DELIMITER_EXCEPTION_MSG = "잘못된 구분자를 입력하셨습습니다.";
    private static final String BAD_NUM_EXCEPTION_MSG = "잘못된 숫자를 입력하셨습니다.";
    private static RuntimeException badDelimiterException = new RuntimeException(BAD_DELIMITER_EXCEPTION_MSG);
    private static RuntimeException badNumsException = new RuntimeException(BAD_NUM_EXCEPTION_MSG);

    private static final String EXTRACT_DELIMITER_REGEX = "^//(.*?)\\n.*$";
    private static final String EXTRACT_NUMS_REGEX = "^//.*\\n(.*?)$";
    private static Pattern delimiterPattern  = Pattern.compile(EXTRACT_DELIMITER_REGEX);
    private static Pattern numsPattern = Pattern.compile(EXTRACT_NUMS_REGEX);

    public static String extractCustomDelimiter(String input) {
        return extract(
                delimiterPattern.matcher(input)
                , badDelimiterException
        );
    }

    public static String extractNums(String input) {
        return extract(
                numsPattern.matcher(input)
                , badNumsException
        );
    }

    private static String extract(Matcher matcher, RuntimeException exception) {
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw exception;
    }
}
