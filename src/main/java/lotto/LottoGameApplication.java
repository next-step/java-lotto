package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.PurchasedLotto;
import lotto.util.ConstUtils;
import lotto.view.Input;
import lotto.view.Output;

public class LottoGameApplication {

    public static void main(String[] args) {
        Input input = new Input();
        int lottoPurchaseMoney = input.getLottoPurchaseMoneyInput();
        int purchasedCount = lottoPurchaseMoney / ConstUtils.LOTTO_WON_UNIT;

        PurchasedLotto purchasedLotto = new PurchasedLotto(purchasedCount);

        Output output = new Output();
        output.printPurchaseResult(purchasedLotto);

        LottoNumbers lastWeekWinningLottoNumbers2 = new LottoNumbers(input.getLastWeekWinningLottoNumbersInput());
        output.printWinningResult(purchasedLotto.matchWinningNumbers(lastWeekWinningLottoNumbers2));
    }
}
