package me.devyonghee.lotto.view;

import java.io.PrintStream;
import java.util.Objects;
import java.util.Scanner;

public final class InputView {

    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNER_NUMBER_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private static final String NULL_SCANNER_ERROR = "scanner must not be null";
    private static final String NULL_GUIDE_PRINTER_ERROR_MESSAGE = "guidePrinter must not be null";

    private final PrintStream guidePrinter;
    private final Scanner scanner;

    private InputView(Scanner scanner, PrintStream guidePrinter) {
        Objects.requireNonNull(scanner, NULL_SCANNER_ERROR);
        Objects.requireNonNull(guidePrinter, NULL_GUIDE_PRINTER_ERROR_MESSAGE);
        this.scanner = scanner;
        this.guidePrinter = guidePrinter;
    }

    public static InputView of(Scanner scanner, PrintStream output) {
        return new InputView(scanner, output);
    }

    public int purchaseAmount() {
        guidePrinter.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        return scanner.nextInt();
    }

    public String winnerNumbers() {
        guidePrinter.println(WINNER_NUMBER_INPUT_MESSAGE);
        return scanner.next();
    }
}

