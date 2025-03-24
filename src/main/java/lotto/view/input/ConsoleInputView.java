package lotto.view.input;

import java.util.Scanner;

public class ConsoleInputView extends BaseInputView {

    static Scanner scanner = new Scanner(System.in);

    @Override
    public String read() {
        return scanner.nextLine();
    }

    @Override
    public void closeScanner() {
        scanner.close();
    }
}
