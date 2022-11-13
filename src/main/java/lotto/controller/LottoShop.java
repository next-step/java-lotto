package lotto.controller;

import lotto.application.LottoService;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoShop {

    private static final InputView INPUT_VIEW = new InputView();
    private static final ResultView RESULT_VIEW = new ResultView();

    private final LottoService lottoService;

    public LottoShop(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void purchase() {
        PurchaseMoney purchaseMoney = new PurchaseMoney(INPUT_VIEW.inputPurchaseMoney());
        Lottos lottos = lottoService.purchaseLottos(purchaseMoney);
        RESULT_VIEW.printLottos(lottos);

        LottoStatistics lottoStatistics = lottoService.statistics(INPUT_VIEW.inputWinningNumbers(), lottos);
        AccordanceCount accordanceCount = lottoStatistics.collectAccordanceCount();
        RESULT_VIEW.printWinningStatistics(accordanceCount);

        double profitRatio = lottoStatistics.calculateProfitRatio(accordanceCount, purchaseMoney);
        RESULT_VIEW.printProfitRatio(profitRatio);
    }
}
