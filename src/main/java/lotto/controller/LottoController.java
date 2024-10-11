package lotto.controller;

import lotto.domain.*;
import lotto.view.ConsoleViewFactory;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

public class LottoController {
    public void start() {
        final LottoInputView lottoInputView = ConsoleViewFactory.createLottoInputView();
        final Money money = lottoInputView.inputMoney();
        final LottoBundle lottoBundle = purchaseLottoBundle(money);
        lottoInputView.displayPurchaseLottoBundle(lottoBundle);
        final Lotto lastWeekWinningLotto = lottoInputView.inputLastWeekWinningLotto();
        final LottoNumber bonusLottoNumber = lottoInputView.inputBonusLottoNumber(lastWeekWinningLotto);

        final LottoWinningEvaluator evaluator = new LottoWinningEvaluator(lottoBundle, lastWeekWinningLotto, bonusLottoNumber);
        final LottoWinningResults results = evaluator.evaluate();

        final LottoResultView lottoResultView = ConsoleViewFactory.createLottoResultView(results);
        lottoResultView.display();

        final LottoStatistics statistics = new LottoStatistics(money, results);
        lottoResultView.displayRate(statistics);
    }

    private LottoBundle purchaseLottoBundle(final Money money) {
        final LottoStore lottoStore = new LottoStore();
        return lottoStore.purchase(money);
    }
}
