package lotto.view;

import java.util.Scanner;

public class InputView {
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static String PURCHASE_AMOUNT_INPUT_DESCRIPTION = "구입금액을 입력해 주세요.";
    private final static String WINNING_NUMBER_INPUT_DESCRIPTION = "지난 주 당첨 번호를 입력해 주세요.";
    public static int inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT_DESCRIPTION);
        return SCANNER.nextInt();
    }

    public static String inputWinningNumber() {
        System.out.println(WINNING_NUMBER_INPUT_DESCRIPTION);
        return SCANNER.next();
    }
}
