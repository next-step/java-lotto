package lotto;

import lotto.data.LottoBall;
import lotto.domain.LottoNumbers;
import lotto.domain.PurchasedLotto;
import lotto.view.Input;
import lotto.view.Output;

public class LottoGameApplication {

    public static void main(String[] args) {
        Input input = new Input();
        int lottoPurchaseMoney = input.getLottoPurchaseMoneyInput();

        PurchasedLotto purchasedLotto = new PurchasedLotto(lottoPurchaseMoney);

        Output output = new Output();
        output.printPurchaseResult(purchasedLotto);

        LottoNumbers lastWeekWinningLottoNumbers = new LottoNumbers(input.getLastWeekWinningLottoNumbersInput());
        LottoBall bonusNumber = LottoBall.selectLottoBall(input.getBonusNumber());
        output.printWinningResult(purchasedLotto.matchWinningNumbers(lastWeekWinningLottoNumbers, bonusNumber));
    }
}
