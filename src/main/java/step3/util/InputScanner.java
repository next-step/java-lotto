package step3.util;

import java.util.Scanner;

public class InputScanner {
    private static final Scanner sc = new Scanner(System.in);

    private InputScanner() {}

    public static int inputNumber() {
        return sc.nextInt();
    }

    public static String inputString() {
        removeNewLine();
        return sc.nextLine();
    }

    private static void removeNewLine() {
        sc.nextLine();
    }
}
