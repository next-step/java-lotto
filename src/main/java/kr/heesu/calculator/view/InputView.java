package kr.heesu.calculator.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    private InputView() {
        scanner = new Scanner(System.in);
    }

    public String getUserInput() {
        return scanner.nextLine();
    }

    public static InputView of() {
        return new InputView();
    }
}
