package lotto.view;

import java.util.Scanner;

import static lotto.view.Output.*;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static Integer inputMoneyForPurchase() {
        String purchase = scanner.nextLine();
        return Integer.parseInt(purchase);
    }

    public static String inputWinningNumbers() {
        printInputWinningNumber();
        return scanner.nextLine();
    }

    public static String inputBonusNumber() {
        printInputBonusBall();
        return scanner.nextLine();
    }
}
