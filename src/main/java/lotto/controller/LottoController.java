package lotto.controller;

import lotto.dto.WinningLottoDto;
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

        WinningLottoDto winningLottoDto = InputView.inputWinningNumbers();
        LottoStatisticsResult statistics = lottoStore.createStatistics(lottoResult, winningLottoDto);

        ResultView.printLottoStatistics(statistics);
    }
}
