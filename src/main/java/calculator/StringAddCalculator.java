package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    static private final String STRING_DELIMITER = ",|:";
    static private final String ERROR_MESSAGE_NOT_NUMBER = "숫자 이외의 값을 입력하였습니다.";
    static private final String ERROR_MESSAGE_MINUS_NUMBER = "음수는 입력할 수 없습니다.";

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
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String splitInput = matcher.group(2);
            return customSplit(customDelimiter, splitInput);
        }
        return input.split(STRING_DELIMITER);
    }

    private String[] customSplit(String customDelimiter, String input) {
        if (customDelimiter.equals("|")) {
            customDelimiter = "\\|";
        }
        return input.split(customDelimiter);
    }

    private int[] convertStringToInteger(String[] splitStrings) {
        int[] splitNumbers = new int[0];

        try {
            splitNumbers = Arrays.stream(splitStrings)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } catch (NumberFormatException e) {
            throw new RuntimeException(ERROR_MESSAGE_NOT_NUMBER);
        }

        validateNumber(splitNumbers);

        return splitNumbers;
    }

    private void validateNumber(int[] splitNumbers) {
        for (int number : splitNumbers) {
            if (number < 0) {
                throw new RuntimeException(ERROR_MESSAGE_MINUS_NUMBER);
            }
        }
    }
}

