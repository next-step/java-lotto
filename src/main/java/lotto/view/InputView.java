package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final String QUESTION_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int inputPurchaseAmount() {
        System.out.println(QUESTION_PURCHASE_AMOUNT_MESSAGE);
        return scanner.nextInt();
    }
}
