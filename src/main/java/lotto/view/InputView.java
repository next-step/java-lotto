package lotto.view;

import java.util.Scanner;

public class InputView {
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static String PURCHASE_AMOUNT_INPUT_DESCRIPTION = "구입금액을 입력해 주세요.";
    public static int inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT_DESCRIPTION);
        return SCANNER.nextInt();
    }
}
