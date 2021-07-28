package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_PURCHASE_MONEY = "구입금액을 입력해 주세요.";

    private InputView() {
    }

    public static int inputPurchaseMoney() {
        System.out.println(INPUT_PURCHASE_MONEY);

        return changeIntInputValue();
    }

    private static int changeIntInputValue() {
        return Integer.parseInt(scanner.nextLine().trim());
    }

}
