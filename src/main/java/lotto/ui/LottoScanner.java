package lotto.ui;

import java.util.Scanner;

public class LottoScanner {
    public static Scanner scanner = new Scanner(System.in);

    public static int insertPurchaseAmount() {
        InputView.printInsertPurchaseAmountPhrase();
        String number = scanner.nextLine();

        return Integer.parseInt(number);
    }

    public static String insertWinningNumbers() {
        InputView.printInsertWinningNumbersPhrase();
        return scanner.nextLine();
    }
}
