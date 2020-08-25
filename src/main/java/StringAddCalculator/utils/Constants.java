package StringAddCalculator.utils;

import java.util.regex.Pattern;

public class Constants {
    public static final Pattern COMPILER_CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");

    /** Exception Message **/
    public static final String ERROR_NEGATIVE_NUMBER = "음수 입력 오류";
    public static final String ERROR_NOT_A_NUMBER = "숫자 아닌 값 입력 오류";
}
