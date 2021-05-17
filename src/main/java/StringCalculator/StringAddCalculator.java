package StringCalculator;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }
        return split(input);
    }

    private static int split(String input) {
        String[] splited = input.split(",|:");
        int result = 0;
        for (String number : splited) {
            result += parseInt(number);
        }
        return result;
    }

    private static final int parseInt(String input) {
        return Integer.parseInt(input);
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }
}
