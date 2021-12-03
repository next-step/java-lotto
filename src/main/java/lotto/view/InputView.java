package lotto.view;

import lotto.domain.Credit;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberFactory;
import lotto.domain.WonLotto;

import java.util.Scanner;

/**
 * @author han
 */
public class InputView {
    private static final String INSERT_PURCHASE_PRICE = "구입금액을 입력해주세요";
    private static final String INSERT_LAST_WON_LOTTO = "지난 주 당첨 번호를 입력해주세요";
    private static final String INSERT_BONUS_NUMBER = "보너스 볼을 입력해주세요";
    private static final String INSERT_NON_AUTO_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해주세요.";
    private static final String INSERT_NON_AUTO_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public Credit start() {
        System.out.println(INSERT_PURCHASE_PRICE);
        String line = scanner.nextLine();
        Credit credit = new Credit(line);
        System.out.println(String.format(PRINT_CREDIT_COUNT, credit.getLottoCount()));
        return credit;
    }

    public WonLotto insertWonLotto() {
        System.out.println(INSERT_LAST_WON_LOTTO);
        String wonNumbers = scanner.nextLine();

        System.out.println(INSERT_BONUS_NUMBER);
        String bonusNumber = scanner.nextLine();
        return WonLotto.of(new Lotto(wonNumbers), new LottoNumber(bonusNumber));
    }
}
