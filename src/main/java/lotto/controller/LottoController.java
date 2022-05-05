package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoWinStatistics;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.strategy.LottoNumberGenerateStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

  public void lottoDraw(LottoNumberGenerateStrategy numberGenerateStrategy) {
    int amount = Integer.parseInt(InputView.inputPurchasedAmount());
    int purchasedLotto = countPurchasedLotto(amount);
    OutputView.outputCountPurchasedLotto(purchasedLotto);

    Lottos lottos = Lottos.create(purchasedLotto, numberGenerateStrategy);
    OutputView.outputPurchasedLottoInfo(lottos);

    WinningLotto winningLotto = WinningLotto.create(InputView.inputLastWeekWinningLotto());

    LottoWinStatistics lottoWinStatistics = new LottoWinStatistics(lottos, winningLotto);
    OutputView.outputWinningRate(lottoWinStatistics.isMatchResult());
    OutputView.outputProfitRatio(lottoWinStatistics.isProfitRatio());
  }

  private int countPurchasedLotto(int amount) {
    return amount / Lotto.PRICE_OF_ONE_LOTTO;
  }
}
