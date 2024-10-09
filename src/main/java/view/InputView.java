package view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    private final String input;

    public InputView() {
        this.input = scanner.nextLine();
    }

    public String getInput() {
        return input;
    }
}
