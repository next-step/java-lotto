package calculator;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (isBlank(input)) {
            return 0;
        }

        return 1;
    }

    private static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
