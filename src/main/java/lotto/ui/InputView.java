package lotto.ui;

import java.util.Scanner;

public class InputView {
    private final static String GET_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private final static String GET_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private final static String GET_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    private final static Scanner scanner = new Scanner(System.in);

    public static int getPurchaseAmount() {
        System.out.println(GET_PURCHASE_AMOUNT);
        return scanner.nextInt();
    }

    public static String getWinningNumber() {
        scanner.nextLine();
        System.out.println(GET_WINNING_NUMBER);
        return scanner.nextLine();
    }

    public static String getBonusNumber() {
        System.out.println(GET_BONUS_NUMBER);
        return scanner.nextLine();
    }
}
