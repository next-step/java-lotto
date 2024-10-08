package calculator.io;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String DEFAULT_DELIMITER = " ";

    @Override
    public String[] getArithmeticExpressionFromUser() {
        String userInput = SCANNER.nextLine();
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
