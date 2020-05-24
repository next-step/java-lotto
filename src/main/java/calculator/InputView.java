package calculator;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public void getUserInput() {
        String userInput = scanner.next();
    }
}
