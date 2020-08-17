package utils;

import exception.StringAdderExceptionHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringSplitter {
    private static final String REGEX_DEFAULT_DELIMITER = "[,:]";
    private static final int CUSTOM_DELIMITER_START_INDEX = 2;
    private static final int CUSTOM_DELIMITER_END_INDEX = 3;
    private static final int CUSTOM_NUMBER_START_INDEX = 5;

    private StringSplitter() { }

    public static List<Integer> splitDelimiter(String input) {
        if (isCustomDelimiter(input)) {
            String customDelimiter = subStringToCustomDelimiter(input);
            String numbers = subStringToCustomNumbers(input);
            return castingToList(numbers.split(customDelimiter));
        }

        return castingToList(input.split(REGEX_DEFAULT_DELIMITER));
    }

    private static List<Integer> castingToList(String[] input) {
        return Arrays.stream(input)
                .map(Integer::parseInt)
                .peek(StringAdderExceptionHandler::validate)
                .collect(Collectors.toList());
    }

    private static boolean isCustomDelimiter(String input) {
        if (input.contains("//")) {
            return true;
        }
        return false;
    }

    private static String subStringToCustomDelimiter(String input) {
        return input.substring(CUSTOM_DELIMITER_START_INDEX, CUSTOM_DELIMITER_END_INDEX);
    }

    private static String subStringToCustomNumbers(String input) {
        return input.substring(CUSTOM_NUMBER_START_INDEX);
    }
}
