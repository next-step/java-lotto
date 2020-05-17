package calculator;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (isBlank(input)) {
            return 0;
        }

        return sum(splitByCommaOrColon(input));
    }

    private static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    private static String[] splitByCommaOrColon(String input) {
        return input.split(",|:");
    }

    private static int sum(String[] inputTokens) {
        int sum = 0;
        for (String token : inputTokens) {
            sum += Integer.parseInt(token);
        }

        return sum;
    }
}
