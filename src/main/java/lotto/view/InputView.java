package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String BUY_AMOUNT_INPUT_TEXT = "구입금액을 입력해 주세요.";

    public static int inputBuyAmount() {
        System.out.println(BUY_AMOUNT_INPUT_TEXT);
        return scanner.nextInt();
    }

}
