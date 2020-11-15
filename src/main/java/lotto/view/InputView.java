package lotto.view;

import lotto.asset.InputViewConst;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.Money;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    private static void println(String str) {
        System.out.println(str);
    }

    public static Money askPurchaseMoney() {
        println(InputViewConst.ASK_PURCHASE_MONEY);
        String money = scanner.nextLine();
        InputValidator.validateNumber(money);
        return new Money(
                Integer.parseInt(money)
        );
    }

    public static Lotto askLotto() {
        String lotto = scanner.nextLine();
        InputValidator.validateNpe(lotto);
        return LottoFactory.createLotto(lotto);
    }

    public static Lotto askWinningLotto() {
        println(InputViewConst.ASK_WINNING_LOTTO);
        return askLotto();
    }

}
