package stringcalculator.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import stringcalculator.domain.Delimiter;
import stringcalculator.domain.Delimiters;

public class InputView {

    protected static final int PREFIX_LENGTH = 2;
    protected static final String DEFAULT_DELIMITER_COMMA = ",";
    protected static final String DEFAULT_DELIMITER_COLON = ":";
    private static final String EMPTY_STRING = "";
    private static final String PREFIX_REGEX = "\\/\\/(.+)";

    public static Delimiters getDelimiter() {
        List<String> delimiters = Arrays.asList(DEFAULT_DELIMITER_COMMA, DEFAULT_DELIMITER_COLON);
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if(!isBlank(input)){
            validatePrefix(input);
            delimiters = Arrays.asList(getRemovePrefix(input));
        }

        return new Delimiters(Delimiter.of(delimiters));
    }

    private static void validatePrefix(String input) {
        if(!input.matches(PREFIX_REGEX)){
            throw new IllegalArgumentException("올바른 입력형식이 아닙니다. ex) //${delimiter}");
        }
    }

    private static boolean isBlank(String input) {
        input = input.trim();
        return input.isEmpty() || input.equals(EMPTY_STRING);
    }

    private static String getRemovePrefix(String input) {
        return input.substring(PREFIX_LENGTH);
    }
}
