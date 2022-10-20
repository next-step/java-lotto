package lotto.view;

import java.util.Scanner;
import lotto.domain.PurchaseMoney;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";

    public PurchaseMoney inputPurchaseMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        int purchaseMoney = toInt(SCANNER.nextLine());

        return new PurchaseMoney(purchaseMoney);
    }

    private int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력해주세요.");
        }
    }
}
