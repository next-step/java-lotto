package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNo;
import lotto.domain.LottoNoPool;
import lotto.domain.Money;

import java.util.Scanner;

public class InputView {
    private static final String SPLIT_REGEX = "[ ,]+";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    private static void println(String str) {
        System.out.println(str);
    }

    public static Money askPurchaseMoney() {
        println("구입금액을 입력해 주세요.");
        String money = scanner.nextLine();
        InputValidator.validateNumber(money);
        return new Money(
                Integer.parseInt(money)
        );
    }

    private static Lotto askLotto() {
        String lotto = scanner.nextLine();
        InputValidator.validateNpe(lotto);
        return new Lotto(
                Splitter.splitIntegers(lotto, SPLIT_REGEX)
        );
    }

    public static Lotto askWinningLotto() {
        println("지난 주 당첨 번호를 입력해 주세요.");
        return askLotto();
    }

    public static LottoNo askBonusBall() {
        println("보너스 볼을 입력해 주세요.");
        String bonus = scanner.nextLine();
        InputValidator.validateNumber(bonus);
        return LottoNoPool.getLottoNo(
                Integer.parseInt(bonus)
        );
    }

}
