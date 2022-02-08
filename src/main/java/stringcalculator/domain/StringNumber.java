package stringcalculator.domain;

import java.util.Objects;

public class StringNumber {

    private static final String USER_INPUT = "0";
    private String stringNumber;

    public StringNumber(final String userInput) {
        this.stringNumber = userInput;
        if (isNullOrEmpty(this.stringNumber)) {
            this.stringNumber = USER_INPUT;
        }
    }

    public String getStringNumber() {
        return stringNumber;
    }

    private boolean isNullOrEmpty(final String stringNumber) {
        return Objects.isNull(stringNumber) || stringNumber.isEmpty();
    }
}
