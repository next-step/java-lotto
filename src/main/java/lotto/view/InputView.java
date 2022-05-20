package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getPurchaseAmount() {
        OutputView.printPurchaseAmount();
        return scanner.nextInt();
    }

    public static String getWinningNumbers() {
        clearScannerBuffer();
        OutputView.printWinningNumbers();
        return scanner.nextLine();
    }

    private static void clearScannerBuffer() {
        scanner.nextLine();
    }

    public static String getBonusNumber() {
        OutputView.printInputBonusNumber();
        return scanner.nextLine();
    }

}
