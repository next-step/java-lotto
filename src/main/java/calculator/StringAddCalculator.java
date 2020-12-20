package calculator;

import util.ValidateUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String VALID_NO_NUMBER_MESSAGE = "숫자가 아닙니다.";
    private static final int DEFAULT_NUM = 0;

    public static int splitAndSum(String input) {
        if (ValidateUtils.isEmpty(input)) {
            return DEFAULT_NUM;
        }

        if (ValidateUtils.isEmptySeparator(input)) {
            return pasreNumber(input);
        }

        Numbers numbers = new Numbers(new StringSplitor(input));
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
