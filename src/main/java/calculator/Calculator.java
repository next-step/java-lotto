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
                .mapToInt(Integer::parseInt)
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


}
