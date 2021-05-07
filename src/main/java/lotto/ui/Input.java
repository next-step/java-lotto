package lotto.ui;

import java.util.Scanner;

import static lotto.ui.Output.*;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static Integer inputMoneyForPurchase() {
        String purchase = scanner.nextLine();
        return Integer.parseInt(purchase);
    }

    public static String inputWinningNumbers() {
        return scanner.nextLine();
    }

    public static String inputBonusNumber() {
        printInputBonusBall();
        return scanner.nextLine();
    }
}
