package edu.nextstep.calculate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-22 02:13
 */
public class ValidationUtils {

    private static final String REGEX_PATTERN_NUMBER = "[0-9]+$";

    public static boolean isSpace(String inputData) {
        return "".equals(inputData);
    }

    public static boolean isNumber(String number) {
        Matcher m = Pattern.compile(REGEX_PATTERN_NUMBER).matcher(number);
        return m.find() ? true : false;
    }

    public static boolean isNegativeNumber(int number) {
        return number < 0 ? true : false;
    }
}
