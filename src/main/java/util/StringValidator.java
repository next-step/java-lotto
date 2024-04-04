package util;

public class StringValidator {

    public void validateCalculated(String input) {
        if (input == null || input.isBlank())
            throw new IllegalArgumentException();
    }
}
