package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final String PURCHASE_AMOUNT_QUESTION = "구입금액을 입력해 주세요.";

    public static Integer scanPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_QUESTION);
        Scanner scanner = new Scanner(System.in);

        return Integer.parseInt(scanner.nextLine());
    }
}
