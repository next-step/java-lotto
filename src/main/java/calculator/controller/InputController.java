package calculator.controller;

import java.util.Scanner;

public class InputController {
    static Scanner scanner = new Scanner(System.in);

    public static String[] getInput() {
        System.out.println("문자열을 입력하세요.");
        String input = scanner.nextLine();
        return input.split(" ");
    }
}
