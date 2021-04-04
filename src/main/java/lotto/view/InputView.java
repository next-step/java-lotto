package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String LAST_WEEK_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String LAST_WEEK_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        return scanner.nextInt();
    }

    public static String inputLastWeekWinningNumber() {
        System.out.println(LAST_WEEK_WINNING_NUMBER);
        return scanner.next();
    }

    public static int inputLastWeekBonusNumber() {
        System.out.println(LAST_WEEK_BONUS_NUMBER);
        return scanner.nextInt();
    }

    public static int inputManualLottoCount() {
        System.out.println(MANUAL_LOTTO_COUNT);
        return scanner.nextInt();
    }

    public static void showManualLotto() {
        System.out.println(MANUAL_LOTTO);
    }

    public static String inputManualLotto() {
        return scanner.next();
    }
}
