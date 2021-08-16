package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public void runAutoLotto() {
        int money = InputView.buyLotto();
        LottoCreator lottoCreator = new LottoCreator(money);
        Lottos lottos = new Lottos(lottoCreator.createLottos(new RandomNumbers()));
        ResultView.printBuyLotto(lottos.value());

        LottoNumbers winningLottoNumbers = new LottoNumbers(InputView.inputWinningNumber());
        LottoMatcher lottoMatcher = new LottoMatcher(winningLottoNumbers, lottos);
        LottoResults lottoResults = new LottoResults(lottoMatcher.classifyByRank());

        ResultView.printResultTitle();
        ResultView.printRankCount(lottoResults.value());
        ResultView.printProfit(lottoResults.calculateTotalRewardsRatio(money));
    }
}
