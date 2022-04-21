package StringCalculator;

public class Equation {
    public Equation(String input) {
        if (isNullOrBlank(input)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_SHOULD_NOT_NULL_OR_BLANK.getMessage());
        }
    }

    private boolean isNullOrBlank(String input) {
        return input == null || input.isBlank();
    }
}
