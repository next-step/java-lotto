package stringCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Validator {
    private static final String VALID_TOTAL_INPUT = "^[0-9\\s*+/\\-]*$";
    private static final String VALID_NUMBER = "[1-9]\\d*";
    private static final String VALID_OPERATOR = "[+\\-*/]";

    private static final String BLANK_INPUT_ERROR = "Blank input is not allowed";
    private static final String INVALID_INPUT_ERROR = "Only Numbers and + - * are allowed (Your input) : ";

    public Validator() {
    }

    public void validate(String input) {
        isNullOrBlank(input);
        isSplitWithDelimiter(input);
        isValidSequence(input);
    }

    private static void isNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(BLANK_INPUT_ERROR);
        }
    }

    private static void isSplitWithDelimiter(String input) {
        Matcher matcher = Pattern.compile(VALID_TOTAL_INPUT).matcher(input);

        if (matcher.find()) {
            return;
        }

        throw new IllegalArgumentException(String.format(INVALID_INPUT_ERROR, input));
    }

    private static void isValidSequence(String input) {
        String[] values = input.split(" ");
        int length = values.length;
        boolean isNumber = true;

        for (int i = 0; i < length; i++) {
            isValidStringAtExactPosition(values[i], isNumber, i);
            isNumber = !isNumber;
        }
        isValidStringAtExactPosition(values[length - 1], true, length - 1);
    }

    private static void isValidStringAtExactPosition(String s, boolean isNumber, int position) {
        Matcher matcher = Pattern.compile(isNumber ? VALID_NUMBER : VALID_OPERATOR).matcher(s);

        if (!matcher.find()) {
            throw new IllegalArgumentException(String.format("Wrong Sequence : %s at %d", s, position));
        }
    }
}
