package lotto.step1.domain;

public class StringAddCalculator {

    private StringAddCalculator() {
    }

    public static int splitAndSum(String input) {
        if (validateInputNullOrEmpty(input)) {
            return 0;
        }
        return 1;
    }

    private static boolean validateInputNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }
}
