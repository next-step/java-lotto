package lotto;

import static lotto.view.InputView.inputBonusNumber;
import static lotto.view.InputView.inputPurchaseAmount;
import static lotto.view.InputView.inputWinningNumbers;
import static lotto.view.ResultView.printLottosCount;
import static lotto.view.ResultView.printReturnRate;
import static lotto.view.ResultView.printWinningResult;

public class LottoProgram {

    public void run() {
        Money purchaseAmount = new Money(inputPurchaseAmount());

        Lottos lottos = Lottos.create(
            purchaseAmount, new RandomNumberGenerator());
        printLottosCount(purchaseAmount.purchase(), lottos);

        WinningLotto winningLotto = new WinningLotto(
            inputWinningNumbers(), inputBonusNumber());

        LottoResult lottoResult = new LottoResult(lottos.getWinningResult(winningLotto));
        printWinningResult(lottoResult);
        printReturnRate(purchaseAmount.purchase(), lottoResult);
    }
}
