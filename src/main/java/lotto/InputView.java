package lotto;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    private int purchaseAmount() {
        String amount = scanner.nextLine();
        return Integer.parseInt(amount);
    }
}
