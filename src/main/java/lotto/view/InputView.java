package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final String INFORMATION_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INFORMATION_LAST_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BLANK = "";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static int inputPurchaseAmount() {
        System.out.println(INFORMATION_PURCHASE_AMOUNT);
        int purchaseAmount = SCANNER.nextInt();
        SCANNER.nextLine();
        return purchaseAmount;
    }

    public static String inputWinningNumbers() {
        System.out.println(BLANK);
        System.out.println(INFORMATION_LAST_WINNING_NUMBER);
        return SCANNER.nextLine();
    }
}
