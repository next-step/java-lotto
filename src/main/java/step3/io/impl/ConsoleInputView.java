package step3.io.impl;

import java.util.Scanner;

import step3.io.InputView;

public class ConsoleInputView implements InputView {

    private Scanner scanner;

    public ConsoleInputView() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String getPrice() {
        return scanner.nextLine();
    }

}
