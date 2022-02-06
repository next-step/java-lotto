package stringcalculator.domain;

import java.util.Objects;
import java.util.Scanner;

public class UserInput {

    private static final String USER_INPUT="0";
    private String userInput;

    public UserInput() {
        userInput = userInputString();
        if (isNullOrEmpty(userInput)) {
            userInput = USER_INPUT;
        }
    }

    private String userInputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String getUserInput() {
        return userInput;
    }

    private boolean isNullOrEmpty(String userInput) {
        return Objects.isNull(userInput) || userInput.isEmpty();
    }
}
