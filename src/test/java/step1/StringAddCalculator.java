package step1;

import java.util.Arrays;

public class StringAddCalculator {
    public int splitAndSum(String input) {
        if(isNullOrEmpty(input)) {
            return 0;
        }

        String[] split = input.split(":|,");

        return Arrays.stream(split)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
