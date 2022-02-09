package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final String MONEY_INPUT_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String LOTTO_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String getMoney() {
        System.out.println(MONEY_INPUT_MESSAGE);

        return scanner.nextLine();
    }

    public static String getLottoWinNumber() {
        System.out.println(LOTTO_NUMBER_MESSAGE);

        return scanner.nextLine();
    }

    public static String getWinBouns() {
        System.out.println(BONUS_BALL_MESSAGE);

        return scanner.nextLine();
    }
}
