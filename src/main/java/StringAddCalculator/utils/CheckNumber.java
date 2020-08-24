package StringAddCalculator.utils;

import java.util.regex.Pattern;

import static StringAddCalculator.utils.Constants.REGEX_NUMBER_ONLY;

public class CheckNumber {

    public static boolean isMinus(int number) {
        return number < 0;
    }

    public static boolean isANumber(int number) {
        String pattern = REGEX_NUMBER_ONLY;
        String stringValue = String.valueOf(number);
        return Pattern.matches(pattern, stringValue);
    }
}