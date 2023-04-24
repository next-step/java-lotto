package calculator.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public String input() {
        String input = scanner.nextLine();
        scanner.close();
        return input;
    }
}
