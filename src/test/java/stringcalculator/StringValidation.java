package stringcalculator;

import java.util.Arrays;

public class StringValidation {
    private static final int MINIMUM_NUMBER = 1;

    public static boolean validNull(String s) {
        return s == null || s.isEmpty();
    }

    public static boolean validLength(String s) {
        return s.length() == 1;
    }

    public static void validNegative(int[] numbers) {
        if (Arrays.stream(numbers).anyMatch(value -> value < MINIMUM_NUMBER)) {
            throw new RuntimeException("음수 포함");
        }
    }
}
