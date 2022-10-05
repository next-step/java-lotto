package lotto.controller;

import lotto.dto.WinningNumber;
import lotto.service.LottoStore;
import lotto.view.InputView;
import lotto.view.LottoResult;
import lotto.view.LottoStatisticsResult;
import lotto.view.ResultView;

public class LottoController {
    private final LottoStore lottoStore = new LottoStore();

    public void start() {
        int purchaseAmount = Integer.parseInt(InputView.inputPurchaseAmount());
        LottoResult lottoResult = lottoStore.buyLotto(purchaseAmount);

        ResultView.printLottoResult(lottoResult);

        WinningNumber winningNumber = InputView.inputWinningNumbers();
        LottoStatisticsResult statistics = lottoStore.createStatistics(lottoResult, winningNumber);

        ResultView.printLottoStatistics(statistics);
    }
}
