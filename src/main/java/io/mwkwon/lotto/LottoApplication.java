package io.mwkwon.lotto;

import io.mwkwon.lotto.domain.*;
import io.mwkwon.lotto.view.InputView;
import io.mwkwon.lotto.view.ResultView;

public class LottoApplication {

    private final InputView inputView;
    private final ResultView resultView;
    private final LottoGenerator lottoGenerator;

    public LottoApplication(InputView inputView, ResultView resultView, LottoGenerator lottoGenerator) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.lottoGenerator = lottoGenerator;
    }

    public void run() {
        LottoStore lottoStore = new LottoStore();
        LottoPayment lottoPayment = LottoPayment.create(inputView);
        resultView.printBuyLottoCount(lottoPayment);
        BuyLottos buyLottos = lottoStore.buyAutoLottos(lottoGenerator, lottoPayment);
        resultView.printBuyLottos(buyLottos);
        Lotto winningLotto = lottoStore.createWinningLotto(inputView);
        WinningRanks winningRanks = lottoStore.calcLottosRank(buyLottos, winningLotto);
        resultView.printWinningStatistics(winningRanks);
        resultView.printProfitRate(winningRanks, lottoPayment);
    }
}
