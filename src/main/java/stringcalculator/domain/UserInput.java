package stringcalculator.domain;

import java.util.Objects;
import java.util.Scanner;

public class UserInput {

    String userInput;

    public UserInput() {
        userInput = userInputString();
        if (isNullOrEmpty(userInput)) {
            userInput = "0";
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
