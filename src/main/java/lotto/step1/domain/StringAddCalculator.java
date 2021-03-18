package lotto.step1.domain;

public class StringAddCalculator {

    private StringAddCalculator() {
    }

    public static int splitAndSum(String input) {
        if (input == null) {
            return 0;
        }

        if (input.trim().isEmpty()) {
            return 0;
        }

        return 1;
    }
}
