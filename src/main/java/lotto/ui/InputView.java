package lotto.ui;

import java.util.Scanner;

public class InputView {
    public static final String BONUS_BALL_MESSAGE = "보너스볼을 입력해주세요";
    public static final String MANUAL_NUMBER_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해주세요.";
    public static final String MANUAL_NUMBERS_INPUT_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호 6개를 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static String getPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        return scanner.nextLine();
    }

    public static String getWinningNumber() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        return scanner.nextLine();
    }

    public static String getBonusNumber() {
        System.out.println(BONUS_BALL_MESSAGE);
        return scanner.nextLine();
    }

    public static String getManualNumberCount() {
        System.out.println(MANUAL_NUMBER_COUNT_MESSAGE);
        return scanner.nextLine();
    }

    public static void printStartManualNumbersInput() {
        System.out.println(MANUAL_NUMBERS_INPUT_MESSAGE);
    }

    public static String getManualNumbers() {
        return scanner.nextLine();
    }

}
