package calculator.util;

import java.util.Objects;

public class ValidateInput {

    private String yourInput;

    public ValidateInput(String input) {
        this.yourInput = isEmptyOrNull(input);
    }

    private String isEmptyOrNull(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            input = "0";
        }
        return input;
    }

    public String getYourInput() {
        return yourInput;
    }
}
