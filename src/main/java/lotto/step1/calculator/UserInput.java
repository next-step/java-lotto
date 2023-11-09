package lotto.step1.calculator;

import lotto.step1.validator.Validator;

public class UserInput {
    private final String userInput;

    public UserInput(final String input) {
        Validator.validateUserInputString(input);

        this.userInput = input;
    }

    public String[] split() {
        return userInput.split(" ");
    }
}
