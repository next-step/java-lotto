package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구매 금액을 입력해주세요.";
    private static final String WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String PRINT_INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static int getPurchaseAmount() {
        printPurchaseAmount();
        return scanner.nextInt();
    }

    private static void printPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
    }

    public static String getWinningNumbers() {
        clearScannerBuffer();
        printWinningNumbers();
        return scanner.nextLine();
    }

    private static void printWinningNumbers() {
        System.out.println(WINNING_NUMBERS);
    }

    private static void clearScannerBuffer() {
        scanner.nextLine();
    }

    public static String getBonusNumber() {
        printInputBonusNumber();
        return scanner.nextLine();
    }

    private static void printInputBonusNumber() {
        System.out.println(PRINT_INPUT_BONUS_NUMBER);
    }

}
