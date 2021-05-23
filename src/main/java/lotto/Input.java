package lotto;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static int insertPurchase() {
        return scanner.nextInt();
    }

    public static String insertWinningNumber() {
        scanner.nextLine();
        return scanner.nextLine();
    }

    public static int insertBonusNumber() {
        return scanner.nextInt();
    }
}
