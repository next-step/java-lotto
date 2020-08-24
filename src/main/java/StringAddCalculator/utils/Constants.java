package StringAddCalculator.utils;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.regex.Pattern;

public class Constants {
    public static final String RESULT_FOR_NONE_INPUT = "0";
    public static final int ADD_NULL_OR_BLANK = 0;
    public static final Pattern COMPILER_CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");
    public static final int CUSTOM_DELIMITER_INDEX = 1;
    public static final int AFTER_CUSTOM_DELIMITER_INDEX = 2;

    public static final String REGEX_NUMBER_ONLY = "^[0-9]{1}$";

    /** Exception Message **/
    public static final String ERROR_NUMBER_MINUS = "음수 입력 오류";
    public static final String ERROR_NOT_A_NUMBER = "숫자 아닌 값 입력 오류";
}
