package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class UserInput {

    private static final String[] INVALID_INPUTS = {"\t", "\n", ""};
    static final String EMPTY_ERROR_MESSAGE = "빈 값을 입력하시면 안됩니다.";
    static final String BLANK_DELIMITER = " ";

    private String userInput;

    public UserInput(String userInput) {
        this.userInput = validateUserInput(userInput);
    }

    private static String validateUserInput(String userInput) {
        if (IntStream.range(0, INVALID_INPUTS.length)
                .anyMatch(i -> INVALID_INPUTS[i].equals(userInput))) {
            throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
        }
        return userInput;
    }

    public List<String> separateInputWithBlank() {
        return Arrays.
                asList(this.userInput.split(BLANK_DELIMITER));
    }

}
