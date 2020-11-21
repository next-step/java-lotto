package view;

import java.util.Scanner;

public final class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static String getUserInput() {
        return SCANNER.nextLine();
    }
}
