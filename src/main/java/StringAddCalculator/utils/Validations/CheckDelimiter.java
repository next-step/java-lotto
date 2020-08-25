package StringAddCalculator.utils.Validations;

import StringAddCalculator.Delimiter;

public class CheckDelimiter {

    public static boolean isInvalidDelimiter(String delimiter) {
        return !CheckDelimiter.isRightDelimiter(delimiter) || delimiter == null || delimiter.trim().isEmpty();
    }

    public static boolean isRightDelimiter(String delimiter) {
       return Delimiter.of(delimiter) != null;
    }
}
