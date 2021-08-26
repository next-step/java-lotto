package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    public StringAddCalculator() {
    }

    public int splitAndSum(String input) {
        if (isNullOrBlank(input)) {
            return 0;
        }
        return sumValues(input.split(",|;"));
    }

    private boolean isNullOrBlank(String input) {
        return input == null || input.trim().isEmpty();
    }

    private int sumValues(String[] input) {
        return Arrays.stream(input)
            .mapToInt(Integer::parseInt)
            .sum();
    }

}
