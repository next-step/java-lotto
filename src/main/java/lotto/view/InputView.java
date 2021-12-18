package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String WINNING_LOTTOTICKET_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    private InputView() {
    }

    public static String purchaseAmount() {
        System.out.println(PURCHASE_AMOUNT);
        return SCANNER.nextLine();
    }

    public static String winningLottoTicketNumber() {
        System.out.println(WINNING_LOTTOTICKET_NUMBERS);
        return SCANNER.nextLine();
    }

    public static String bonusNumber() {
        System.out.println(BONUS_NUMBER);
        return SCANNER.nextLine();
    }

}
