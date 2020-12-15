package stringcalculator.domain;

import stringcalculator.validator.Validator;

public class Text {
    private final Validator validator;

    public Text(String text) {
        this.validator = new Validator(text);
    }

    public boolean isBlank() {
        return validator.isBlank();
    }
}
