package lotto.step1.input;

import lotto.step1.validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class UserInput {
    private final List<String> nums = new ArrayList<>();
    private final List<String> operators = new ArrayList<>();

    public UserInput(final String input) {
        Validator.validateUserInputString(input);

        final String[] inputs = input.split(" ");
        separateInputs(inputs);
    }

    private void separateInputs(final String[] inputs) {
        for (String input : inputs) {
            separateNumericAndSymbolLists(input);
        }
    }

    private void separateNumericAndSymbolLists(final String input) {
        try {
            Integer.parseInt(input);
            nums.add(input);
        } catch (NumberFormatException e) {
            operators.add(input);
        }
    }

    public List<String> getNums() {
        return nums;
    }

    public List<String> getOperators() {
        return operators;
    }
}
