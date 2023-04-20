package calculator.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public String getStringInput() {
        return scanner.nextLine();
    }

    public void closeScanner() {
        scanner.close();
    }

}
