package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_BUY_PRICE = "구입금액을 입력해 주세요.";

    public static int setPayPriceLotto(Scanner scanner) {
        System.out.println(INPUT_BUY_PRICE);
        return scanner.nextInt();
    }

}
