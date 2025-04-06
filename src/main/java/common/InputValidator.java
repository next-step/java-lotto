package common;

public class InputValidator {

    public static void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT);
        }
    }
}
