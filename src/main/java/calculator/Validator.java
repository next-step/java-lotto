package calculator;

public class Validator {

    public void isNullOrEmpty(String input) {
        checkNullOrEmpty(input);
    }

    private void checkNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
