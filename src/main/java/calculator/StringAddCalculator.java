package calculator;

import java.util.Arrays;

public class StringAddCalculator {
    private String stringDelimiter = ",|:";

    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] splitStrings = splitInput(input);

        int[] splitNumbers = convertStringToInteger(splitStrings);

        int result = Arrays.stream(splitNumbers)
                .sum();

        return result;
    }

    private String[] splitInput(String input) {
        return input.split(stringDelimiter);
    }

    private int[] convertStringToInteger(String[] splitStrings) {
        return Arrays.stream(splitStrings)
                .mapToInt(Integer::parseInt)
                .toArray();
    }


}
