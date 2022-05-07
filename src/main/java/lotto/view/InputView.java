package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_USER_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_PREVIOUS_WEEK_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";

    public static int inputUserAmount() {
        System.out.println(INPUT_USER_AMOUNT_MESSAGE);
        return SCANNER.nextInt();
    }

    public static String inputPreviousWeekWinningNumber() {
        System.out.println(INPUT_PREVIOUS_WEEK_WINNING_NUMBER_MESSAGE);

        SCANNER.nextLine();
        return SCANNER.nextLine();
    }

    public static String inputBonusBall() {
        System.out.println(INPUT_BONUS_BALL_MESSAGE);

        return SCANNER.nextLine();
    }
}
