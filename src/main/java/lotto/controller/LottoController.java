package lotto.controller;

import java.util.List;
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
    int purchasedManual = InputView.inputNumberOfManual(purchasedLotto);
    List<String> manualLottos = InputView.inputManualLottoNumbers(purchasedManual);

    OutputView.outputCountPurchasedLotto(purchasedManual, purchasedLotto);

    Lottos lottos = Lottos.create(purchasedLotto, manualLottos, numberGenerateStrategy);
    OutputView.outputPurchasedLottoInfo(lottos);

    WinningLotto winningLotto = WinningLotto.create(InputView.inputLastWeekWinningLotto(),
        InputView.inputBonusLottoNumber());

    LottoWinStatistics lottoWinStatistics = new LottoWinStatistics(lottos, winningLotto);
    OutputView.outputWinningRate(lottoWinStatistics.isMatchResult());
    OutputView.outputProfitRatio(lottoWinStatistics.isProfitRatio());
  }

  private int countPurchasedLotto(int amount) {
    return amount / Lotto.PRICE_OF_ONE_LOTTO;
  }
}
