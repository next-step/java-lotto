package lotto.step1.calculator;

import lotto.step1.validator.Validator;

public class UserInput {
    private final String[] inputs;

    public UserInput(final String input) {
        Validator.validateUserInputString(input);

        this.inputs = input.split(" ");
    }

    public String[] getInputs() {
        return inputs;
    }
}
