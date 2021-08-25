package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoController {

    public void runAutoLotto() {
        Money lottoPurchasePrice = InputView.inputPurchasePrice();
        int manualLottoCount = InputView.inputManualLottoCount();
        List<String> manualLottos = InputView.inputManualLottos(manualLottoCount);

        LottosCreator lottosCreator = new LottosCreator(lottoPurchasePrice, manualLottoCount);
        Lottos lottos = lottosCreator.createLottos(manualLottos, RandomNumbersCreator.getInstance());

        ResultView.printBuyLotto(lottos.values());

        WinningLotto winningLotto = new WinningLotto(
                new Lotto(InputView.inputWinningNumber()),
                new LottoNumber(InputView.inputBonusBallNumber()));

        Map<Rank, Integer> lottoRankResultMap = LottoMatcher.matchWithWinningLottoNumbers(lottos, winningLotto);

        ResultView.printRankCount(lottoRankResultMap);
        ResultView.printProfit(LottoMatcher.calculateTotalRewardsRatio(lottoPurchasePrice, lottoRankResultMap));
    }
}
