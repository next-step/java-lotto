package lotto.step1.domain;

import lotto.step1.utils.StringSpliter;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringAddCalculator {

    private StringAddCalculator() {
    }

    public static Number splitAndSum(String input) {
        if (validateInputNullOrEmpty(input)) {
            return Number.of(0);
        }
        String[] tokens = StringSpliter.splitToStringArray(input);
        Numbers numbers = getNumbers(tokens);
        return numbers.getSum();
    }

    private static Numbers getNumbers(String[] tokens) {
        return Numbers.of(Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .mapToObj(number -> Number.of(number))
                .collect(Collectors.toList()));
    }

    private static boolean validateInputNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }
}
