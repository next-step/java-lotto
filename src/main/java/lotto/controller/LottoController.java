package lotto.controller;

import lotto.domain.*;
import lotto.view.ConsoleViewFactory;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

public class LottoController {
    public void start() {
        final LottoInputView lottoInputView = ConsoleViewFactory.createLottoInputView();
        final Money money = lottoInputView.inputMoney();

        final LottoStore lottoStore = new LottoStore();
        final int manualLottoCount = lottoInputView.inputManualLottoCount();
        final LottoBundle manualLottoBundle = lottoStore.purchase(lottoInputView.inputManualLottoBundle(manualLottoCount));

        final LottoBundle autoLottoBundle = lottoStore.purchase(remainingMoney(money, manualLottoCount));
        final LottoBundle lottoBundle = LottoBundle.mergeAutoAndManualLottoBundle(manualLottoBundle, autoLottoBundle);
        lottoInputView.displayPurchaseLottoBundle(lottoBundle);

        final Lotto lastWeekWinningLotto = lottoInputView.inputLastWeekWinningLotto();
        final LottoNumber bonusLottoNumber = lottoInputView.inputBonusLottoNumber();
        final LastWeekWinningLotto lottoLastWinning = new LastWeekWinningLotto(lastWeekWinningLotto, bonusLottoNumber);

        final LottoWinningEvaluator evaluator = new LottoWinningEvaluator(lottoBundle, lottoLastWinning);
        final LottoWinningResults results = evaluator.evaluate();

        final LottoResultView lottoResultView = ConsoleViewFactory.createLottoResultView(results);
        lottoResultView.display();

        final LottoStatistics statistics = new LottoStatistics(money, results);
        lottoResultView.displayRate(statistics);
    }

    private static Money remainingMoney(final Money money, final int lottoCount) {
        final Money purchasedMoney = new Money(lottoCount * LottoStore.LOTTO_PURCHASE_AMOUNT);
        return money.minus(purchasedMoney);
    }
}
