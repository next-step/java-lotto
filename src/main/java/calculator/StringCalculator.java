package calculator;

public class StringCalculator {

    public StringCalculator(String input) {
        if(isBlank(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isBlank(String input) {
        return input == null || input.isBlank();
    }
}
