package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_BUY_PRICE = "구입금액을 입력해 주세요.";
    private static final String BUY_LOTTO_QUANTITY = "개를 구매했습니다.";

    public static int setPayPriceLotto(Scanner scanner) {
        System.out.println(INPUT_BUY_PRICE);
        return scanner.nextInt();
    }

    public static void printLottoBuyQuantity(int quantity) {
        System.out.println(quantity + BUY_LOTTO_QUANTITY);
    }

}
