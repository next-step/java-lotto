package lotto.step2.view;

import java.util.Scanner;

public class InputView {

    private static final String LOTTO_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int enterLottoPurchaseAmount() {
        System.out.println(LOTTO_PURCHASE_AMOUNT_MESSAGE);
        return scanner.nextInt()/ 1000;
    }
}
