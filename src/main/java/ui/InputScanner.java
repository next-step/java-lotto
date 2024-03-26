package ui;

import java.util.Scanner;

public class InputScanner {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputToInt() {
        return SCANNER.nextInt();
    }

    public static String inputToString() {
        return SCANNER.next();
    }
}
