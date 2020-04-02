package StringCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final int ZERO = 0;


    int execute(String input) {
        if (checkIsEmptyOrNull(input)) {
            return ZERO;
        }

        List<Integer> inputs = split(input)
                .stream()
                .map(item -> stringToInteger(item))
                .map(item -> checkBiggerThanZero(item))
                .collect(Collectors.toList());


        return sum(inputs);
    }

    private boolean checkIsEmptyOrNull(String input) {
        return input == null || input.equals("");
    }

    private int stringToInteger(String input) {
        return Integer.parseInt(input);
    }

    int checkBiggerThanZero(int input) {
        if (input < 0) {
            throw new IllegalArgumentException("invalid input");
        }
        return input;
    }

    private int sum(List<Integer> inputs) {
        int sum = 0;
        for (int input : inputs) {
            sum += input;
        }
        return sum;
    }


    private List<String> split(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] tokens = matcher.group(2).split(customDelimiter);
            return Arrays.asList(tokens);
        }
        return Arrays.asList(input.split(DEFAULT_DELIMITER));
    }


}
