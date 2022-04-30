package lotto.controller;

import lotto.model.Lottos;
import lotto.strategy.RandomNumberGenerateStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

  private static final int LOTTO_BASIC_AMOUNT = 1000;

  public void lottoDraw() {
     int amount = InputView.inputPurchasedAmount();
     int purchasedLotto = countPurchasedLotto(amount);
    OutputView.outputCountPurchasedLotto(purchasedLotto);

    Lottos lottos = Lottos.create(purchasedLotto, new RandomNumberGenerateStrategy());
    OutputView.outputPurchasedLottoInfo(lottos);
  }

  private int countPurchasedLotto(int amount) {
    return amount/LOTTO_BASIC_AMOUNT;
  }
}
