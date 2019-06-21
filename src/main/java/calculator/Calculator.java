package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    public static final String DEFAULT_DELIMITER = "[,:]";

    public static int process(String input) {

        if (isBlank(input)) {
            return 0;
        }

        List<Integer> numbers = refineInput(input);
        return sum(numbers);
    }

    private static List<Integer> refineInput(String input) {

        List<String> tokens = split(input);
        validateTokens(tokens);

        return tokens.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    private static void validateTokens(List<String> tokens) {

        try {
            boolean isContainsNegative = tokens.stream().map(Integer::parseInt).anyMatch(number -> number < 0);
            if (isContainsNegative) {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> split(String input) {

        return Arrays.asList(input.split(DEFAULT_DELIMITER));
    }

    private static boolean isBlank(String input) {

        return input == null || input.isEmpty();
    }

    private static int sum(List<Integer> numbers) {

        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
