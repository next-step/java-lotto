package lotto;

import java.util.HashMap;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputInteger() {
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    public static String inputString() {
        return scanner.nextLine();
    }
}
