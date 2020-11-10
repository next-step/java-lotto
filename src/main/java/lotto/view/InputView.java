package lotto.view;

import lotto.asset.InputViewConst;
import lotto.lib.MoneyValidator;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);;

    private InputView() {}

    public static int askPurchaseMoney() {
        System.out.println(InputViewConst.ASK_PURCHASE_MONEY);
        String money = scanner.nextLine();
        MoneyValidator.validateMoney(money);
        return Integer.parseInt(money);
    }
}
