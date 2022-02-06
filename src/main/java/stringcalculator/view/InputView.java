package stringcalculator.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import stringcalculator.domain.Delimiters;

public class InputView {

    private static final int PREFIX_LENGTH = 2;
    private static final String DEFAULT_DELIMITER_COMMA = ",";
    private static final String DEFAULT_DELIMITER_COLON = ":";
    private static final String PREFIX_REGEX = "//(.+)";
    private static final String DEFAULT_NUMBER = "0";

    public static Delimiters getDelimiters() {
        String input = getInput();

        if (!isBlank(input)) {
            validatePrefix(input);
            return new Delimiters(Collections.singletonList(removePrefix(input)));
        }

        return new Delimiters(Arrays.asList(DEFAULT_DELIMITER_COMMA, DEFAULT_DELIMITER_COLON));
    }

    public static String getExpression() {
        String input = getInput();

        if (isBlank(input)) {
            return DEFAULT_NUMBER;
        }
        return input;
    }

    private static String getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static boolean isBlank(String input) {
        return input.trim().isEmpty();
    }

    private static void validatePrefix(String input) {
        if (!input.matches(PREFIX_REGEX)) {
            throw new IllegalArgumentException("올바른 입력형식이 아닙니다. ex) //${delimiter}");
        }
    }

    private static String removePrefix(String input) {
        return input.substring(PREFIX_LENGTH);
    }
}
