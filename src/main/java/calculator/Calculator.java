package calculator;

import util.ErrorMessage;

public class Calculator {
    private Calculator() {
    }

    public static Calculator create() {
        return new Calculator();
    }

    public int run(String input) {
        validateInput(input);

        return 0;
    }

    private void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT);
        }
    }
}
