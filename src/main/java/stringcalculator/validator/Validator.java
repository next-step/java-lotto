package stringcalculator.validator;

public class Validator {
    private final String input;

    public Validator(String input) {
        this.input = input;
    }

    public boolean isBlank() {
        return this.input == null || this.input.trim().length() == 0;
    }
}
