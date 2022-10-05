package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {
    public static void run() {
        Money purchaseAmount = InputView.scanPurchaseAmount();
        Integer manualLottoCount = InputView.scanManualLottoCount(purchaseAmount);
        Lottos manualLottos = InputView.scanManualLottos(manualLottoCount);

        LottoStore lottoStore = new LottoStore(new RandomLottoFactory());
        Lottos lottos = lottoStore.sell(purchaseAmount, manualLottos);

        ResultView.printPurchase(manualLottoCount, lottos);

        Lotto winningLotto = InputView.scanWinningNumbers();
        LottoNumber bonusNumber = InputView.scanBonusNumber();

        ResultView.printWinningStatistics(lottos, winningLotto, bonusNumber);
    }
}
