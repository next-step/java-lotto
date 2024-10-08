package calculator;

import static calculator.ErrorMessage.BLINK_INPUT_ERROR;
import static calculator.ErrorMessage.INPUT_IS_NOT_NUMBER;

public class Calculator {
    public static void validateString(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException(BLINK_INPUT_ERROR);
        }
    }

    private static boolean isBlank(String input) {
        return (input == null || input.trim().isEmpty());
    }

    public static int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(INPUT_IS_NOT_NUMBER);
        }
    }

}
