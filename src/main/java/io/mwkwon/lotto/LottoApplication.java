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
        LottoStore lottoStore = new LottoStore();
        LottoPayment lottoPayment = lottoStore.createLottoPayment(dataGenerator);
        resultView.printBuyLottoCount(lottoPayment);
        BuyLottos buyLottos = lottoStore.buyAutoLottos(lottoGenerator, lottoPayment);
        resultView.printBuyLottos(buyLottos);
        Lotto winningLotto = lottoStore.createWinningLotto(dataGenerator);
        LottoNumber bonusBallLottoNumber = lottoStore.createBonusBallLottoNumber(dataGenerator, winningLotto);
        WinningRanks winningRanks = lottoStore.calcLottosRank(buyLottos, winningLotto);
        resultView.printWinningStatistics(winningRanks);
        resultView.printProfitRate(winningRanks, lottoPayment);
    }
}
