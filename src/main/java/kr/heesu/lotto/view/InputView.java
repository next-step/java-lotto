package kr.heesu.lotto.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    private InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String read() {
        return this.scanner.nextLine();
    }

    public static InputView of() {
        return new InputView();
    }
}
