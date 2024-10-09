package lotto.controller;

import lotto.domain.*;
import lotto.view.ConsoleViewFactory;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

public class LottoController {
    public void start() {
        final LottoInputView lottoInputView = ConsoleViewFactory.createLottoInputView();
        final LottoPurchaseResult lottoPurchaseResult = lottoInputView.inputMoney();
        final Lotto lastWeekWinningLotto = lottoInputView.inputLastWeekWinningLotto();

        final LottoWinningEvaluator evaluator = new LottoWinningEvaluator(lottoPurchaseResult.getLottoBundle(), lastWeekWinningLotto);
        final LottoWinningResults results = evaluator.evaluate();

        final LottoResultView lottoResultView = ConsoleViewFactory.createLottoResultView(results);
        lottoResultView.display();

        final LottoStatistics statistics = new LottoStatistics(lottoPurchaseResult.getPurchasedMoney(), results);
        lottoResultView.displayRate(statistics);
    }
}
