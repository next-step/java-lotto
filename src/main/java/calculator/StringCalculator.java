package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final int EMPTY_NUM = 0;
    private static final String COMMA_OR_COLON_DELIMITER = ",|:";
    private static final String COMSTOM_REGEX = "//(.)\\n(.*)";
    private static final String NUMBER_REGEX = "^[0-9]*$";

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
            checkNumgerString(numStr);
            int num = stringToNum(numStr);
            result += num;
        }

        return result;
    }

    void checkNumgerString(String val) throws RuntimeException {
        if (!Pattern.matches(NUMBER_REGEX, val)) {
            throw new RuntimeException("계산할 문자열은 숫자형태만 허용합니다.");
        }
    }

    String[] stringToNumStrings(String val) {
        Matcher matcher = Pattern.compile(COMSTOM_REGEX).matcher(val);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return val.split(COMMA_OR_COLON_DELIMITER);
    }

    int stringToNum(String val) {
        int num = Integer.parseInt(val);
        checkNegativeNum(num);
        return num;
    }

    void checkNegativeNum(int val) throws RuntimeException {
        if (0 > val) {
            throw new RuntimeException("계산할 문자열에 음수는 허용하지 않습니다.");
        }
    }

    boolean isNull(String val) {
        if (val == null) {
            return true;
        }
        return false;
    }

    boolean isEmpty(String val) {
        val = val.trim();
        if (val.isEmpty()) {
            return true;
        }
        return false;
    }
}
