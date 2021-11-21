package lotto.view;

import java.util.Scanner;

public class Input {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ENTER_NUMBER = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

    private Input() {
    }

    public static int askPurchaseAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT);
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(ENTER_NUMBER);
            return askPurchaseAmount();
        }
    }

    public static String askWinningNumber() {
        System.out.println(ASK_WINNING_NUMBER);
        return SCANNER.nextLine();
    }

}
