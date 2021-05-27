package io.mwkwon.lotto;

import io.mwkwon.lotto.domain.*;
import io.mwkwon.lotto.interfaces.DataGenerator;
import io.mwkwon.lotto.interfaces.LottoGenerator;
import io.mwkwon.lotto.view.ResultView;

public class LottoApplication {

    private final DataGenerator dataGenerator;
    private final ResultView resultView;
    private final LottoGenerator lottoGenerator;

    public LottoApplication(DataGenerator dataGenerator, ResultView resultView, LottoGenerator lottoGenerator) {
        this.dataGenerator = dataGenerator;
        this.resultView = resultView;
        this.lottoGenerator = lottoGenerator;
    }

    public void run() {
        LottoStore lottoStore = new LottoStore(dataGenerator, lottoGenerator);
        LottoPayment lottoPayment = lottoStore.createLottoPayment();
        resultView.printBuyLottoCount(lottoPayment);
        BuyLottos buyLottos = lottoStore.buyAutoLottos(lottoPayment);
        resultView.printBuyLottos(buyLottos);
        Lotto winningLotto = lottoStore.createWinningLotto();
        LottoNumber bonusBallLottoNumber = lottoStore.createBonusBallLottoNumber(winningLotto);
        WinningRanks winningRanks = lottoStore.calcLottosRank(buyLottos, winningLotto, bonusBallLottoNumber);
        resultView.printWinningStatistics(winningRanks);
        resultView.printProfitRate(winningRanks, lottoPayment);
    }
}
