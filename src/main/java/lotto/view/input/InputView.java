package lotto.view.input;

import java.util.Scanner;

public class InputView {

    public static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String ENTER_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String ENTER_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int enterLottoAmount() {
        System.out.println(ENTER_PURCHASE_AMOUNT);
        return scanner.nextInt();
    }

    public static String enterWinningNumbers() {
        System.out.println(ENTER_WINNING_NUMBERS);
        scanner.nextLine();
        return scanner.nextLine();
    }

    public static int enterBonusNumber() {
        System.out.println(ENTER_BONUS_NUMBER);
        return scanner.nextInt();
    }
}
