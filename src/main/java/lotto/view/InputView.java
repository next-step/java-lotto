package lotto.view;

import java.util.Scanner;

public class InputView {

    public static int promptInt(String message) {
        System.out.println(message);
        return getScanner().nextInt();
    }

    public static String promptString(String message) {
        System.out.println(message);
        return getScanner().nextLine();
    }

    private static Scanner getScanner() {
        return new Scanner(System.in);
    }
}