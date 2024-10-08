package calculator.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputStr(Runnable messagePrinter) {
        messagePrinter.run();
        return SCANNER.nextLine();
    }
}
