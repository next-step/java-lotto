package calculator.validation;

import java.util.List;

import static calculator.message.ErrorMessage.*;

public class InputValidation {

    private static final String NUMBER_REGEX = ".*[^0-9].*";
    private static final String OPERATOR_REGEX = ".*[^+\\-*/].*";

    public boolean validation(List<String> input) {
        nullOrEmptyCheck(input);
        for (int step = 0; step < input.size(); step++) {
            checkSetValidation(input.get(step), step);
        }
        return true;
    }

    public void nullOrEmptyCheck(List<String> input) {
        if (input == null || input.size() <= 2) {
            throw new IllegalArgumentException(INPUT_NULL_OR_EMPTY.getMessage());
        }
    }

    private boolean checkSetValidation(String input, int step) {
        if (step % 2 == 0) {
            checkNumberValidate(input);
        }
        if (step % 2 == 1) {
            checkOperatorValidate(input);
        }
        return true;
    }

    private void checkNumberValidate(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(INPUT_NUMBER_LENGTH.getMessage());
        }
        if (input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(INPUT_NOT_NUMBER.getMessage());
        }
    }

    private void checkOperatorValidate(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException(INPUT_NOT_OPERATOR_LENGTH.getMessage());
        }
        if (input.matches(OPERATOR_REGEX)) {
            throw new IllegalArgumentException(INPUT_NOT_OPERATOR.getMessage());
        }
    }
}
