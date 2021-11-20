package lotto.view;

import lotto.exception.NotInstanceException;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    private InputView() {
        throw new NotInstanceException();
    }

    public static int getPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        return SCANNER.nextInt();
    }
}
