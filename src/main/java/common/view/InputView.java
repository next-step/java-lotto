package common.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String nextLine() {
        return SCANNER.nextLine();
    }

    public static String nextLine(String message) {
        OutputView.print(message);
        return SCANNER.nextLine();
    }

    public static int nextInt(String message) {
        return Integer.parseInt(nextLine(message));
    }
}
