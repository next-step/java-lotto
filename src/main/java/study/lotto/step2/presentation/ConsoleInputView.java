package study.lotto.step2.presentation;

import java.util.Scanner;

public class ConsoleInputView {
    private static final String INSERT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INSERT_LAST_WEEK_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INSERT_BONUS_BALL = "보너스 볼을 입력해 주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);

    private ConsoleInputView() {
    }

    public static String askPurchaseAmount() {
        System.out.println(INSERT_PURCHASE_AMOUNT);
        return SCANNER.nextLine();
    }

    public static String askBonusBall() {
        System.out.println(INSERT_BONUS_BALL);
        return SCANNER.nextLine();
    }

    public static String askLastWeekWinningNumbers() {
        System.out.println(INSERT_LAST_WEEK_WINNING_NUMBERS);
        return SCANNER.nextLine();
    }
}
