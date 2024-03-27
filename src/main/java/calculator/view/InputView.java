package calculator.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String inputFormula() {
        return scanner.nextLine();
    }

    public void close() {
        this.scanner.close();
    }
}
