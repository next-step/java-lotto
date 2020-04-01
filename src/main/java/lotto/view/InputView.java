package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String PURCHASE_NOTICE = "구입금액을 입력해 주세요.";
    private static final int DEFAULT_PRICE = Integer.MIN_VALUE;

    public static int getPurchasePrice() {
        System.out.println(PURCHASE_NOTICE);

        try {
            return Integer.parseInt(scanner.next());
        } catch (NumberFormatException e) {
            return DEFAULT_PRICE;
        }
    }

}
