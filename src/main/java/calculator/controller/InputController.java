package calculator.controller;

import java.util.Scanner;

public class InputController {
    static Scanner scanner = new Scanner(System.in);

    public static String[] getInput() {
        String input = scanner.nextLine();
        return input.split(" ");
    }
}
