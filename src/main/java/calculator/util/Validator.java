package calculator.util;

public class Validator {

    public void checkNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

}
