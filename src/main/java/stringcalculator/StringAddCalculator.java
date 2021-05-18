package stringcalculator;

public class StringAddCalculator {
    private static final int DEFAULT_RETURN_VALUE = 0;

    public static int splitAndSum(String text) {
        if (validateNullOrEmpty(text)) {
            return DEFAULT_RETURN_VALUE;
        }
        return -1;
    }

    private static boolean validateNullOrEmpty(String text) {
        if (text == null || text.isEmpty()) {
            return true;
        }
        return false;
    }
}
