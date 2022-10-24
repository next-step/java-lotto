package lotto;

import java.util.HashMap;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputInteger() {
        int value = SCANNER.nextInt();
        SCANNER.nextLine();
        return value;
    }

    public static String inputString() {
        return SCANNER.nextLine();
    }
}
