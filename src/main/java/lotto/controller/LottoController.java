package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public void runAutoLotto() {
        int lottoPurchasePrice = InputView.inputPurchasePrice();
        LottoCreator lottoCreator = new LottoCreator(lottoPurchasePrice);
        Lottos lottos = new Lottos(lottoCreator.createLottos(new RandomNumbersCreator()));
        ResultView.printBuyLotto(lottos.value());

        Lotto winningLotto = new Lotto(InputView.inputWinningNumber());
        LottoMatcher lottoMatcher = new LottoMatcher(winningLotto, lottos);
        LottoResults lottoResults = new LottoResults(lottoMatcher.classifyByRank());

        ResultView.printResultTitle();
        ResultView.printRankCount(lottoResults.value());
        ResultView.printProfit(lottoResults.calculateTotalRewardsRatio(lottoPurchasePrice));
    }
}
