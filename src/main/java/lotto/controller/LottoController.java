package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.LottoResult;
import lotto.view.LottoStatistics;
import lotto.view.ResultView;

public class LottoController {
    private final LottoService lottoService = new LottoService();

    public void start() {
        int purchaseAmount = Integer.parseInt(InputView.inputPurchaseAmount());

        LottoResult result = lottoService.buyLotto(purchaseAmount);

        ResultView.printLottoResult(result);

        String inputWinningNumber = InputView.inputWinningNumber();
        LottoStatistics lottoStatistics = lottoService.lottoStatistics(inputWinningNumber);
        lottoStatistics.getStatistics();
    }
}
