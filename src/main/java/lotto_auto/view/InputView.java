package lotto_auto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    public String getPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        String purchaseAmount = SCANNER.next();
        SCANNER.nextLine();
        return purchaseAmount;
    }

    public String getWinningNumbers() {
        System.out.println();
        System.out.println(WINNING_NUMBERS_MESSAGE);
        return SCANNER.next();
    }
}
