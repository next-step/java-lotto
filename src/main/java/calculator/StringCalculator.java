package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final int EMPTY_NUM = 0;
    private static final String COMMA_DELIMITER = ",";
    private static final String COMMA_OR_COLON_DELIMITER = ",|:";
    private static final String COMSTOM_REG_EX = "//(.)\\n(.*)";

    int result;

    int add(String val) {

        if (isNull(val)) {
            return EMPTY_NUM;
        }
        if (isEmpty(val)) {
            return EMPTY_NUM;
        }
        String[] numStrings = stringToNumStrings(val);
        for (String numStr : numStrings) {
            int num = stringToNum(numStr);
            result += num;
        }

        return result;
    }

    String[] stringToNumStrings(String val) {
        Matcher matcher = Pattern.compile(COMSTOM_REG_EX).matcher(val);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return val.split(COMMA_OR_COLON_DELIMITER);
    }

    int stringToNum(String val) {
        return Integer.parseInt(val);
    }

    boolean isNull(String value) {
        if (value == null) {
            return true;
        }
        return false;
    }

    boolean isEmpty(String value) {
        value = value.trim();
        if (value.isEmpty()) {
            return true;
        }
        return false;
    }
}
