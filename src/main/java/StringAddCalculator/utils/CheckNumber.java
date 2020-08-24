package StringAddCalculator.utils;

import java.util.regex.Pattern;

import static StringAddCalculator.utils.Constants.REGEX_NEGATIVE_NUMBER;
import static StringAddCalculator.utils.Constants.REGEX_NUMBER_ONLY;

public class CheckNumber {

    public static boolean isMinus(int number) {
        String stringValue = Integer.toString(number);
        return Pattern.matches(REGEX_NEGATIVE_NUMBER, stringValue);
    }

    public static boolean isANumber(int number) {
        String stringValue = Integer.toString(number);
        return Pattern.matches(REGEX_NUMBER_ONLY, stringValue);
    }
}