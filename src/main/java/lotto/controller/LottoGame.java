package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGame {
    public static void run() {
        Money purchaseAmount = InputView.scanPurchaseAmount();
        Integer manualLottoCount = InputView.scanManualLottoCount();
        Lottos manualLottos = InputView.scanManualLottos(manualLottoCount);

        LottoStore lottoStore = new LottoStore(new RandomLottoFactory());
        Lottos lottos = lottoStore.sell(purchaseAmount, manualLottos);

        ResultView.printPurchase(manualLottoCount, lottos);

        List<Integer> winningNumbers = InputView.scanWinningNumbers();
        Integer bonusNumber = InputView.scanBonusNumber();

        ResultView.printWinningStatistics(lottos, new Lotto(winningNumbers), bonusNumber);
    }
}
