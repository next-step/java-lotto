package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final String GET_MONEY_FROM_USER_MESSAGE = "구입 금액을 입력해주세요.";
    private static final String GET_WINNING_LOTTO_FROM_USER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String GET_BONUS_LOTTO_FROM_USER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String getMoneyToPurchase() {
        System.out.println(GET_MONEY_FROM_USER_MESSAGE);
        return SCANNER.nextLine();
    }

    public static String getWinningLotto() {
        System.out.println(GET_WINNING_LOTTO_FROM_USER_MESSAGE);
        return SCANNER.nextLine();
    }

    public static String getBonusBall() {
        System.out.println(GET_BONUS_LOTTO_FROM_USER_MESSAGE);
        return SCANNER.nextLine();
    }
}
