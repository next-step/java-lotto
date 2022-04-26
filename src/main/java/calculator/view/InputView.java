package calculator.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String getCommand() {
        return SCANNER.nextLine();
    }
}
