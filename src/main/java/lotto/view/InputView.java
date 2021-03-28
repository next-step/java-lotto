package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String LAST_WEEK_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

    public static int inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        return scanner.nextInt();
    }

    public static String inputLastWeekWinningNumber() {
        System.out.println(LAST_WEEK_WINNING_NUMBER);
        return scanner.next();
    }
}
