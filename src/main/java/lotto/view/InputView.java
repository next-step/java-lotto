package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final int MINIMUM_PURCHASE_MONEY = 1000;
    private static final String MINIMUM_PURCHASE_MONEY_MESSAGE = "구입금액은 최소 1000원 이상이어야 합니다.";

    public int inputPurchaseMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        int purchaseMoney = toInt(SCANNER.nextLine());
        validatePurchaseMoney(purchaseMoney);

        return purchaseMoney;
    }

    private int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력해주세요.");
        }
    }

    private void validatePurchaseMoney(int purchaseMoney) {
        if (purchaseMoney < MINIMUM_PURCHASE_MONEY) {
            throw new IllegalArgumentException(MINIMUM_PURCHASE_MONEY_MESSAGE);
        }
    }
}
