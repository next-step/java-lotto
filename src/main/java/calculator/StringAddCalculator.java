package calculator;

import util.ValidateUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final String VALID_NO_NUMBER_MESSAGE = "숫자가 아닙니다.";
    public static final String SPLIT_SEPARATOR = ",:|";

    public static int splitAndSum(String input) {
        if (ValidateUtils.isEmpty(input)) {
            return 0;
        }

        if (ValidateUtils.isEmptySeparator(input)) {
            return pasreNumber(input);
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        String[] inputs;
        if (m.find()) {
            String customDelimiter = m.group(1);
            inputs = m.group(2).split(customDelimiter);
        } else {
            inputs = input.split(SPLIT_SEPARATOR);
        }

        Numbers numbers = new Numbers(inputs);
        return numbers.sum();
    }

    private static int pasreNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VALID_NO_NUMBER_MESSAGE);
        }
    }


}
