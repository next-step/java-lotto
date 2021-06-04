package lotto.view;

import java.util.Scanner;

import static lotto.view.Output.*;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static Integer inputMoneyForPurchase() {
        printStartMessage();
        String purchase = scanner.nextLine();
        return Integer.parseInt(purchase);
    }

    public static String inputWinningNumbers() {
        printInputWinningNumber();
        return scanner.nextLine();
    }

    public static int inputBonusNumber() {
        printInputBonusBall();
        return Integer.parseInt(scanner.nextLine());
    }
}
