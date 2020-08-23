package StringAddCalculator.utils;

public class CheckString {

    public static boolean isNullOrBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
