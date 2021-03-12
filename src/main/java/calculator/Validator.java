package calculator;

import java.awt.*;

public final class Validator {

    public static boolean isBlankOrEmpty(String input) {
        if(isBlank(input) || isEmpty(input)) {
            return true;
        }

        return false;
    }

    private static boolean isEmpty(String input) {
        return input.equals("");
    }

    private static boolean isBlank(String input) {
        return input == null;
    }

    public static boolean isOnlyOneNumber(String text) {
        return text.matches(Constants.REGEX_ONLY_ONE_NUMBER);
    }

    public static void isLessThenZero(String text) {
        if(Integer.parseInt(text) < Constants.ZERO) {
            throw new RuntimeException(Constants.IS_NOT_VALID_INPUT);
        }
    }
}
