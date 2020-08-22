package kr.heesu.lotto.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    private InputView() {
        this.scanner = new Scanner(System.in);
    }

    private static class InnerHolder {
        private static final InputView INSTANCE = new InputView();

    }

    public static InputView getInstance() {
        return InnerHolder.INSTANCE;
    }

    public String read() {
        return this.scanner.nextLine();
    }
}
