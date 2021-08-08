package lotto.view;

import lotto.domain.PurchaseAmount;

import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    private InputView(Scanner scanner) {
        this.scanner = Objects.requireNonNull(scanner);
    }

    public static InputView of(InputStream inputStream) {
        return new InputView(new Scanner(inputStream));
    }

    public PurchaseAmount getPurchaseAmount() {
        String input = scanner.nextLine();
        return PurchaseAmount.of(Integer.parseInt(input));
    }
}
