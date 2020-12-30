package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구매금액을 입력해 주세요.";

    public static int inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        return inputAmount();
    }

    private static int inputAmount() {
        return SCANNER.nextInt();
    }
}
