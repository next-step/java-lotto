package view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static int getInputNumber(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }

    public static String getInputString(String message) {
        System.out.println(message);
        return scanner.next();
    }
}
