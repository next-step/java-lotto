package lotto.view;

import java.util.Scanner;

public class InputView {
    private final static String INPUT_MONEY_QUESTION = "구입금액을 입력해 주세요.";
    private final static String WINNER_NUMBER_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";
    private final static String BONUS_NUMBER_QUESTIONS = "보너스 볼을 입력해 주세요.";
    private final static Scanner SCANNER = new Scanner(System.in);

    public static int questionInputMoney() {
        System.out.println(INPUT_MONEY_QUESTION);
        int money = SCANNER.nextInt();
        SCANNER.nextLine();
        return money;
    }

    public static String questionWinnerNumber() {
        System.out.println();
        System.out.println(WINNER_NUMBER_QUESTION);
        return SCANNER.nextLine();
    }

    public static String questionBonusLottoNumber() {
        System.out.println();
        System.out.println(BONUS_NUMBER_QUESTIONS);
        return SCANNER.nextLine();
    }
}
