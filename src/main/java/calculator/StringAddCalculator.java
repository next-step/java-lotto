package calculator;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (isBlank(input)) {
            return 0;
        }

        String[] inputTokens = input.split(",");
        return Integer.parseInt(inputTokens[0]);
    }

    private static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
