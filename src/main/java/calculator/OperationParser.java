package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperationParser {

    private static final String DEFAULT_DELIMITER = ",|:";

    public static String parseDelimiter(String text) {
        validate(text);

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            return m.group(1);
        }

        return DEFAULT_DELIMITER;
    }

    private static void validate(String text) {
        if(text == null || text.trim().isEmpty()) {
            throw new RuntimeException("문자열 계산기의 입력은 빈값이 될 수 없습니다.");
        }
    }

    public static String getDefaultOperation(String text, String delimiter) {
        if(DEFAULT_DELIMITER.equals(delimiter)) {
            return text;
        }

        return text.substring(text.indexOf("\n")+1);
    }

}
