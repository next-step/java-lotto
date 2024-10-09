package calculator.io;

import calculator.validator.UserInputValidator;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String DEFAULT_DELIMITER = " ";

    @Override
    public String[] getArithmeticExpressionFromUser() {
        String userInput = SCANNER.nextLine();
        UserInputValidator.checkIfInputIsEmptyOrBlank(userInput);
        return toStringArray(userInput);
    }

    private String[] toStringArray(String userInput) {
        return Arrays.stream(getSplit(userInput))
                .toArray(String[]::new);
    }

    private String[] getSplit(String userInput) {
        return userInput.split(DEFAULT_DELIMITER);
    }
}
