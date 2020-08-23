package StringAddCalculator.utils;

import StringAddCalculator.Delimiter;

public class checkDelimiter {

    public static boolean isRightDelimiter(String delimiter) {
       return Delimiter.of(delimiter) != null;
    }
}
