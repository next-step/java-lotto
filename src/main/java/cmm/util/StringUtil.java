package cmm.util;


import step1.exception.CharacterAndMinusCustomException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    private static final Pattern COMPARE_NUMERIC = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isEmpty(String value) {
        if (value == null) {
            return true;
        }

        return "".equals(value);
    }

    public static int stringToInt(String stringNumber) throws CharacterAndMinusCustomException {
        Matcher m = COMPARE_NUMERIC.matcher(stringNumber);
        if (!m.find()) {
            throw new CharacterAndMinusCustomException("문자입니다.");
        }

        int number = Integer.parseInt(stringNumber);

        if (number < 0) {
            throw new CharacterAndMinusCustomException("음수 사용 불가");
        }
        return number;
    }
}
