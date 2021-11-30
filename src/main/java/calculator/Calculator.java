package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String[] DELIMITERS = {",", ":"};
    private static final String DELIMITERS_REGEX = String.join("|", DELIMITERS);

    public static int compute(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers;

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if(matcher.find()) {
            String delimiter = matcher.group(1);
            numbers = matcher.group(2).split(delimiter);
        } else {
            numbers = input.split(DELIMITERS_REGEX);
        }

        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }


}
