package calculator.validator;

public class UserInputValidator {

    public static void checkIfInputIsEmptyOrBlank(String userInput) {
        if (userInput == null || userInput.isBlank()) {
            throw new IllegalArgumentException("올바른 입력값이 아닙니다.");
        }
    }
}
