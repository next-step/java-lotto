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
        PurchaseQuantity manualLottoPurchaseQuantity = lottoStore.createManualLottoPurchaseQuantity(lottoPayment);
        BuyLottos manualLottos = lottoStore.createManualLottos(manualLottoPurchaseQuantity);
        BuyLottos autoLottos = lottoStore.buyAutoLottos(lottoPayment, manualLottoPurchaseQuantity);
        resultView.printBuyLottoCount(manualLottos, autoLottos);
        BuyLottos buyLottos = manualLottos.merge(autoLottos);
        resultView.printBuyLottos(buyLottos);
        Lotto lotto = lottoStore.createWinningLotto();
        LottoNumber bonusBallLottoNumber = lottoStore.createBonusBallLottoNumber(lotto);
        WinningLotto winningLotto = WinningLotto.create(lotto, bonusBallLottoNumber);
        WinningRanks winningRanks = lottoStore.calcLottosRank(buyLottos,winningLotto);
        resultView.printWinningStatistics(winningRanks);
        resultView.printProfitRate(winningRanks, lottoPayment);
    }
}
