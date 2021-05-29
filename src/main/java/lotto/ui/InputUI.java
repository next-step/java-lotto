package lotto.ui;

import java.util.Scanner;

public class InputUI {
    static Scanner scanner = new Scanner(System.in);

    public static int inputPurchasingAmount() {
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputWinningNumbers() {
        return scanner.nextLine();
    }

    public static int inputBonusNumber() {
        return Integer.parseInt(scanner.nextLine());
    }
}
