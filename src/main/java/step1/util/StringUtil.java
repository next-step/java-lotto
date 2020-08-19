package step1.util;


import step1.exception.UserCustomException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringUtil {
    public static boolean isEmpty(String value) {
        if (value == null) {
            return true;
        }

        return "".equals(value);
    }

    public static String[] splitWithDelemeter(String value, String delemeter) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(value);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return value.split(delemeter);
    }

    public static int StringToInt(String value) throws UserCustomException {
        if(!value.matches("-?\\d+(\\.\\d+)?")) {
            throw new UserCustomException("문자입니다.");
        }

        int number = Integer.parseInt(value);

        if (number < 0) {
            throw new UserCustomException("음수 사용 불가");
        }
        return number;
    }
}
