package step1;

import java.util.List;

public class InputParser {

    private static final String DELIMITER = " ";

    public List<String> splitUserInput(String userInput) {
        validateUserInput(userInput);
        return List.of(userInput.split(DELIMITER));
    }

    private void validateUserInput(String userInput) {
        if (userInput == null || userInput.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자열입니다.");
        }
    }
}
