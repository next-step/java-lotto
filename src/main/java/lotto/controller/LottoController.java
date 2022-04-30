package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoNumberComparsion;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.strategy.RandomNumberGenerateStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

  public void lottoDraw() {
    int amount = Integer.parseInt(InputView.inputPurchasedAmount());
    int purchasedLotto = countPurchasedLotto(amount);
    OutputView.outputCountPurchasedLotto(purchasedLotto);

    Lottos lottos = Lottos.create(purchasedLotto, new RandomNumberGenerateStrategy());
    OutputView.outputPurchasedLottoInfo(lottos);

    WinningLotto winningLotto = WinningLotto.create(InputView.inputLastWeekWinningLotto());

    LottoNumberComparsion lottoNumberComparsion = new LottoNumberComparsion(lottos, winningLotto);
    OutputView.outputWinningRate(lottoNumberComparsion.getMatchResult());
    OutputView.outputProfitRatio(lottoNumberComparsion.getProfitRatio());
  }

  private int countPurchasedLotto(int amount) {
    return amount / Lotto.PRICE_OF_ONE_LOTTO;
  }
}
