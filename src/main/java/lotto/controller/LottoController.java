package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Map;

public class LottoController {

    public void runAutoLotto() {
        int lottoPurchasePrice = InputView.inputPurchasePrice();
        LottosCreator lottosCreator = new LottosCreator(lottoPurchasePrice);
        Lottos lottos = lottosCreator.createLottos(new RandomNumbersCreator());
        ResultView.printBuyLotto(lottos.value());

        Lotto winningLotto = new Lotto(InputView.inputWinningNumber());
        Map<Rank, Integer> lottoRankResultMap = LottoMatcher.matchWithWinningLottoNumbers(lottos, winningLotto);

        ResultView.printResultTitle();
        ResultView.printRankCount(lottoRankResultMap);
        ResultView.printProfit(LottoMatcher.calculateTotalRewardsRatio(lottoPurchasePrice, lottoRankResultMap));
    }
}
