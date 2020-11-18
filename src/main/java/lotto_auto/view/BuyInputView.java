package lotto_auto.view;

import java.util.Scanner;

public class BuyInputView {

    public static final String ENTER_BUY_LOTTO_MONEY_MESSAGE = "구입금액을 입력해 주세요.";

    public static int enter() {
        System.out.println(ENTER_BUY_LOTTO_MONEY_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
