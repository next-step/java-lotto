package lotto.ui;

import java.util.List;
import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static Integer inputMoneyForPurchase() {
        return scanner.nextInt();
    }

    public static String inputWinningNumbers() {

        return scanner.nextLine();
    }

    public static Integer inputBonusNumber() {
        return scanner.nextInt();
    }
}
