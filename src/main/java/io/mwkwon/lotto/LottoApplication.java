package io.mwkwon.lotto;

import io.mwkwon.lotto.domain.Lotto;
import io.mwkwon.lotto.domain.LottoPayment;
import io.mwkwon.lotto.domain.LottoStore;
import io.mwkwon.lotto.domain.WinningRanks;
import io.mwkwon.lotto.view.InputView;
import io.mwkwon.lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoPayment lottoPayment = inputView.requestInputPayment();
        LottoStore lottoStore = new LottoStore();
        lottoStore.buyAutoLottos(lottoPayment);
        inputView.printBuyLottoCount(lottoPayment);
        inputView.printBuyLottos(lottoStore);
        Lotto winningLotto = inputView.requestWinningLottoNumbers();
        WinningRanks winningRanks = lottoStore.calcLottosRank(winningLotto);
        ResultView resultView = new ResultView();
        resultView.printWinningStatistics(winningRanks);
        resultView.printProfitRate(winningRanks, lottoPayment);
    }
}
