package lotto;

import static lotto.view.InputView.inputPurchaseAmount;
import static lotto.view.InputView.inputWinningNumbers;
import static lotto.view.ResultView.printLottosCount;
import static lotto.view.ResultView.printReturnRate;
import static lotto.view.ResultView.printWinningResult;

public class LottoProgram {

    public void run() {
        int purchaseAmount = inputPurchaseAmount();

        Lottos lottos = Lottos.create(
            LottoStore.sellLotto(purchaseAmount), new RandomLottoGenerator());
        printLottosCount(purchaseAmount, lottos);

        Lotto winningLotto = new Lotto(inputWinningNumbers());
        LottoResult lottoResult = new LottoResult(lottos.getWinningResult(winningLotto));
        printWinningResult(lottoResult);
        printReturnRate(purchaseAmount, lottoResult);
    }
}
