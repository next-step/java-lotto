package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String GET_PURCHASE_AMOUNT_QUESTION = "구입금액을 입력해 주세요.";
    private static final String GET_WINNING_NUMBER_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String GET_BONUS_NUMBER_QUESTION = "보너스 볼을 입력해 주세요.";

    private InputView() {

    }

    public static int getPurchaseAmount() {
        System.out.println(GET_PURCHASE_AMOUNT_QUESTION);
        return scanner.nextInt();
    }

    public static String getWinningNumber() {
        System.out.println(GET_WINNING_NUMBER_QUESTION);
        scanner.nextLine();
        return scanner.nextLine();
    }

    public static int getBonusNumber() {
        System.out.println(GET_BONUS_NUMBER_QUESTION);
        return scanner.nextInt();
    }
}
