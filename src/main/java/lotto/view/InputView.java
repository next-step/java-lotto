package lotto.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String nextLine(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }
}
