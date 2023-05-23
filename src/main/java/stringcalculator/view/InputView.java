package stringcalculator.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputEquation() {
        return scanner.nextLine();
    }
}
