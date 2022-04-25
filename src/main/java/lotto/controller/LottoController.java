package lotto.controller;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.Rank;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {


  public static void run() {
    PurchaseAmount purchaseAmount = InputView.getPurchaseAmount();
    int lottoCount = purchaseAmount.getLottoCount();
    Lottos lottos = Lottos.autoCreate(lottoCount);
    ResultView.printLottos(lottos);
    Lotto lastWeekWinningLotto = InputView.getLastWeekWinningLotto();
    Map<Rank, Integer> result = lottos.calculate(lastWeekWinningLotto);
  }
}
