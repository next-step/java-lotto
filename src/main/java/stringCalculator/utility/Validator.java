package stringCalculator.utility;

public class Validator {
    private static final String EMPTY_STRING = "";

    public boolean isValidInput(String input) {
        return !isNull(input) && !isEmpty(input);
    }

    private boolean isEmpty(String input) {
        return input.equals(EMPTY_STRING);
    }

    private boolean isNull(String input) {
        return input == null;
    }
}
