package calculator.view;

import java.util.Scanner;

public class InputView {
    private InputView() {
        throw new IllegalArgumentException("utility class");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static String input() {
        return scanner.nextLine();
    }
}
