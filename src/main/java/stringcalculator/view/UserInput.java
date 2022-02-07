package stringcalculator.view;

import java.util.Objects;
import java.util.Scanner;

public class UserInput {

    private static final Scanner SCANNER = new Scanner(System.in);

    public String userInputString() {
        String userInput = SCANNER.nextLine().trim();
        if (isNullOrEmpty(userInput)) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요");
        }
        return userInput;
    }

    private boolean isNullOrEmpty(String userInput) {
        return Objects.isNull(userInput) || userInput.isEmpty();
    }
}
