package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    private static final String DEFAULT_DELIMITER = "[,:]";
    public static final String CUSTOM_DELIMITER_START_SYMBOL = "//";
    public static final String CUSTOM_DELIMITER_END_SYMBOL = "\\n";
    public static final int BLANK_VALUE = 0;

    public static int process(String input) {

        if (isBlank(input)) {
            return BLANK_VALUE;
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

        if (input.startsWith(CUSTOM_DELIMITER_START_SYMBOL)) {
            int endIndex = input.indexOf(CUSTOM_DELIMITER_END_SYMBOL);
            String customDelimiter = input.substring(CUSTOM_DELIMITER_START_SYMBOL.length(), endIndex);
            int startTokenIndex = endIndex + CUSTOM_DELIMITER_END_SYMBOL.length();

            return Arrays.asList(input.substring(startTokenIndex).split(customDelimiter));
        }
        return Arrays.asList(input.split(DEFAULT_DELIMITER));
    }

    private static boolean isBlank(String input) {

        return input == null || input.isEmpty();
    }

    private static int sum(List<Integer> numbers) {

        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
