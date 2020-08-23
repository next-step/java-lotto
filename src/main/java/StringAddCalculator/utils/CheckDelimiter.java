package StringAddCalculator.utils;

import StringAddCalculator.Delimiter;

public class CheckDelimiter {

    public static boolean isInvalidDelimiter(String delimiter) {
        return !CheckDelimiter.isRightDelimiter(delimiter) || CheckString.isNullOrBlank(delimiter);
    }

    public static boolean isRightDelimiter(String delimiter) {
       return Delimiter.of(delimiter) != null;
    }
}
