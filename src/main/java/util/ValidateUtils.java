package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ValidateUtils {
    private static final String COMMA_SEPARATOR = ",";
    private static final String COLON_SEPARATOR = ":";
    private static final String VERTICAL_BAR_SEPARATOR = "|";
    private static final String EMPTY_SEPARATOR = "";
    private static final String VALID_NEGATIVE_NUMBER_MESSAGE = "음수는 입력 불가능합니다.";

    public static boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    public static boolean isEmptySeparator(String input) {
        if (input == null) {
            return true;
        }

        if (isMatchCustomSeparator(input)) {
            return false;
        }

        return countSeparators(input) == 0;
    }

    public static boolean isMatchCustomSeparator(String input) {
        return Pattern.matches("//(.)\n(.*)", input);
    }

    private static int countSeparators(String input) {
        List<String> inputs = new ArrayList<>(Arrays.asList(input.split(EMPTY_SEPARATOR)));
        return (int) inputs.stream()
                .filter(t -> isSeparator(t))
                .count();
    }

    private static boolean isSeparator(String input) {
        return (input.equals(COLON_SEPARATOR)
                || input.equals(COMMA_SEPARATOR)
                || input.equals(VERTICAL_BAR_SEPARATOR));
    }

    public static void validateNegativeNumber(int num) {
        if (num < 0) {
            throw new IllegalArgumentException(VALID_NEGATIVE_NUMBER_MESSAGE);
        }
    }
}
