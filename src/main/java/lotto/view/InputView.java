package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String LOTTO_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LAST_WINNING_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String SELECT_LOTTO_BUY_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";

    private InputView() {
    }

    public static String scanLottoMoney() {
        System.out.println(LOTTO_MONEY_MESSAGE);

        return scanner.nextLine();
    }

    public static String scanWinningLottoNumber() {
        System.out.println(LAST_WINNING_LOTTO_MESSAGE);

        return scanner.nextLine();
    }

    public static String scanBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);

        return scanner.nextLine();
    }

    public static String scanSelectLottoBuyCount() {
        System.out.println(SELECT_LOTTO_BUY_COUNT_MESSAGE);

        return scanner.nextLine();
    }
}
