package stringcalculator.domain;

import java.util.Objects;

public class UserInput {

    private static final String USER_INPUT = "0";
    private String userInput;

    public UserInput(final String userInput) {
        this.userInput = userInput;
        if (isNullOrEmpty(this.userInput)) {
            this.userInput = USER_INPUT;
        }
    }

    public String getUserInput() {
        return userInput;
    }

    private boolean isNullOrEmpty(final String userInput) {
        return Objects.isNull(userInput) || userInput.isEmpty();
    }
}
