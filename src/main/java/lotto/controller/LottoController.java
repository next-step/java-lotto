package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoNumberComparison;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.strategy.NumberGenerateStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

  public void lottoDraw(NumberGenerateStrategy numberGenerateStrategy) {
    int amount = Integer.parseInt(InputView.inputPurchasedAmount());
    int purchasedLotto = countPurchasedLotto(amount);
    OutputView.outputCountPurchasedLotto(purchasedLotto);

    Lottos lottos = Lottos.create(purchasedLotto, numberGenerateStrategy);
    OutputView.outputPurchasedLottoInfo(lottos);

    WinningLotto winningLotto = WinningLotto.create(InputView.inputLastWeekWinningLotto());

    LottoNumberComparison lottoNumberComparsion = new LottoNumberComparison(lottos, winningLotto);
    OutputView.outputWinningRate(lottoNumberComparsion.getMatchResult());
    OutputView.outputProfitRatio(lottoNumberComparsion.getProfitRatio());
  }

  private int countPurchasedLotto(int amount) {
    return amount / Lotto.PRICE_OF_ONE_LOTTO;
  }
}
