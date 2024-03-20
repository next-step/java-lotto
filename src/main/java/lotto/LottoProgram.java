package lotto;

import static lotto.view.InputView.inputPurchaseAmount;
import static lotto.view.InputView.inputWinningNumbers;
import static lotto.view.ResultView.printLottosCount;
import static lotto.view.ResultView.printReturnRate;
import static lotto.view.ResultView.printWinningResult;

public class LottoProgram {

    public void run() {
        int purchaseAmount = inputPurchaseAmount();

        Lottos lottos = LottoMachine.createLottos(
            LottoStore.sellLotto(purchaseAmount), new RandomLottoGenerator());
        printLottosCount(purchaseAmount, lottos);

        WinningLotto winningLotto = new WinningLotto(inputWinningNumbers());
        LottoResult lottoResult = new LottoResult(lottos.getWinningResult(winningLotto));
        printWinningResult(lottoResult);
        printReturnRate(purchaseAmount, lottoResult);
    }
}
