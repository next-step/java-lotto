package calculator.validator;

import calculator.exception.ApplicationException;

public class UserInputValidator {

    public static void checkIfInputIsEmptyOrBlank(String userInput) {
        if (userInput == null || userInput.isBlank()) {
            throw new ApplicationException("올바른 입력값이 아닙니다.");
        }
    }
}
