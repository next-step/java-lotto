package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER_REGEX = ",|:";

    public int sum(String input) {
        String[] splitInput = split(input, DEFAULT_DELIMITER_REGEX);

        int[] numbers = Arrays.stream(splitInput).mapToInt(Integer::parseInt).toArray();

        return Arrays.stream(numbers).reduce(Integer::sum).getAsInt();
    }

    private String[] split(String input, String delimiter) {
        return input.split(delimiter);
    }
}
