package calculator;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        int sum = 0;

        if (!validationCheck(input)) {
            return sum;
        }

        return Integer.parseInt(input);
    }

    private static boolean validationCheck(String input) {
        if (input == null) {
            return false;
        }

        if (input.isEmpty()) {
            return false;
        }
        return true;
    }
}
