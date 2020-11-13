package lotto.view;

import lotto.asset.InputViewConst;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.Money;
import lotto.utils.validator.LottoValidator;
import lotto.utils.validator.MoneyValidator;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    private InputView() {}

    private static void println(String str) {
        System.out.println(str);
    }

    public static Money askPurchaseMoney() {
        println(InputViewConst.ASK_PURCHASE_MONEY);
        String money = scanner.nextLine();
        MoneyValidator.validateMoney(money);
        return new Money(money);
    }

    public static String askLottoStr() {
        String lottoStr = scanner.nextLine();
        LottoValidator.validateLottoStr(lottoStr);
        return lottoStr;
    }

    public static Lotto askWinningLotto() {
        println(InputViewConst.ASK_WINNING_LOTTO);
        return LottoFactory.createLotto(
                askLottoStr()
        );
    }

}
