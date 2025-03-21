package lotto;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String MESSAGE_FOR_INPUT = "Please enter the expression : ";

    public static String getStringInput() {
        System.out.print(MESSAGE_FOR_INPUT);
        return scanner.nextLine().trim();
    }
}
