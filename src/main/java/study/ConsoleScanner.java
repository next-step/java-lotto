package study;

import java.util.Scanner;

public class ConsoleScanner {

    private static final Scanner SCANNER = new Scanner(System.in);

    public String input() {
        String input = SCANNER.nextLine();
        StringValidator.validateIsBlank(input);
        return input;
    }
}
