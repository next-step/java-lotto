package view;

import java.util.Scanner;

public class KeyboardInput {
    private static Scanner scanner = new Scanner(System.in);

    private KeyboardInput() {
    }

    public static String readInputString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
