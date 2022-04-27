package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

  public static void run() {
    PurchaseAmount purchaseAmount = InputView.getPurchaseAmount();
    int lottoCount = purchaseAmount.getLottoCount();
    Lottos lottos = Lottos.autoCreate(lottoCount);
    ResultView.printLottos(lottos);

    Lotto lastWeekWinningLotto = InputView.getLastWeekWinningLotto();

    LottoResult result = lottos.calculate(lastWeekWinningLotto);
    ResultView.printResult(result, result.calculateYield(purchaseAmount));
  }


}
