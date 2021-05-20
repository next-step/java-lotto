package stringCalculator.utility;

public class Validator {
    private static final String EMPTY_STRING = "";

    public static boolean isValidInput(String input) {
        return !isNull(input) && !isEmpty(input);
    }

    private static boolean isEmpty(String input) {
        return input.equals(EMPTY_STRING);
    }

    private static boolean isNull(String input) {
        return input == null;
    }
}