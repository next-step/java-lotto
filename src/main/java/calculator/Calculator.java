package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String[] DELIMITERS = {",", ":"};
    private static final String DELIMITERS_REGEX = String.join("|", DELIMITERS);

    private static final String CUSTOM_DELIMITER_INPUT_REGEX = "//(.)\n(.*)";
    private static final int DELIMITER_GROUP_INDEX = 1;
    private static final int CALCULATE_GROUP_INDEX = 2;

    private static final Pattern inputPattern = Pattern.compile(CUSTOM_DELIMITER_INPUT_REGEX);

    public static int compute(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = splitInput(input);
        return Arrays.stream(numbers)
                .mapToInt(Calculator::parseInt)
                .sum();
    }

    private static String[] splitInput(String input) {
        Matcher matcher = inputPattern.matcher(input);
        if(matcher.find()) {
            String delimiter = matcher.group(DELIMITER_GROUP_INDEX);
            return matcher.group(CALCULATE_GROUP_INDEX).split(delimiter);
        }
        return input.split(DELIMITERS_REGEX);
    }

    private static int parseInt(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 타입만 입력 가능합니다.");
        }
        if (number < 0) {
            throw new RuntimeException("양수만 입력 가능합니다.");
        }
        return number;
    }
}
