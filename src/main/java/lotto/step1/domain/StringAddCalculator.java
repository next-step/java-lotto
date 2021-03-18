package lotto.step1.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringAddCalculator {

    private static final String TOKEN_DELIMITER = ",|;";

    private StringAddCalculator() {
    }

    public static int splitAndSum(String input) {
        if (validateInputNullOrEmpty(input)) {
            return 0;
        }

        getNumbers(input);

        return 1;
    }

    private static Numbers getNumbers(String input) {
        String[] tokens = input.split(TOKEN_DELIMITER);

        return Numbers.of(Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .mapToObj(number -> Number.of(number))
                .collect(Collectors.toList()));
    }

    private static boolean validateInputNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }
}
