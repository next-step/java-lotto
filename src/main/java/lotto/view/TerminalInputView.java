package lotto.view;

import java.util.Scanner;

public class TerminalInputView {

    public int purchaseAmount() {
        int purchaseAmount = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            purchaseAmount = Integer.parseInt(line);
        }
        return purchaseAmount;
    }
}
