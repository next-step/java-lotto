package calculator;

public class StringCalculator {

    public StringCalculator(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException();
        }

        if (isNotOperation(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotOperation(String input) {
        return !Operation.isOperation(input);
    }

    private boolean isBlank(String input) {
        return input == null || input.isBlank();
    }
}
