package lotto;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    private final AmountValidator amountValidator;

    public InputView(final Scanner scanner, final AmountValidator amountValidator) {
        this.scanner = scanner;
        this.amountValidator = amountValidator;
    }

    private int purchaseAmount() {
        String amount = scanner.nextLine();
        amountValidator.validate(amount);
        return Integer.parseInt(amount);
    }
}
