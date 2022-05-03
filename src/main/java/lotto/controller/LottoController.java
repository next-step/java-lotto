package lotto.controller;

import static lotto.domain.Lotto.INVALID_SIZE_MESSAGE;
import static lotto.domain.PurchaseAmount.INVALID_PURCHASE_AMOUNT_MESSAGE;
import static lotto.domain.WinningLotto.INVALID_BONUS_MESSAGE;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

  public static void run() {
    PurchaseAmount purchaseAmount = getPurchaseAmount();
    int lottoCount = purchaseAmount.getLottoCount();

    List<Lotto> manualLottos = getManualLottos(lottoCount);
    Lottos lottos = Lottos.create(manualLottos, lottoCount - manualLottos.size());
    ResultView.printLottos(lottos);

    WinningLotto lastWeekWinningLotto = getLastWeekWinningLotto();

    LottoResult result = lottos.calculate(lastWeekWinningLotto);
    ResultView.printResult(result, result.calculateYield(purchaseAmount));
  }

  private static PurchaseAmount getPurchaseAmount() {
    PurchaseAmount purchaseAmount;
    try {
      purchaseAmount = InputView.getPurchaseAmount();
    } catch (IllegalArgumentException e) {
      System.out.println(INVALID_PURCHASE_AMOUNT_MESSAGE);
      purchaseAmount = getPurchaseAmount();
    }
    return purchaseAmount;
  }

  private static List<Lotto> getManualLottos(int lottoCount) {
    List<Lotto> lottos;
    try {
      lottos = InputView.getManualLottos(lottoCount);
    } catch (IllegalArgumentException e) {
      System.out.println(INVALID_SIZE_MESSAGE);
      lottos = getManualLottos(lottoCount);
    }
    return lottos;
  }

  private static WinningLotto getLastWeekWinningLotto() {
    WinningLotto winningLotto;
    try {
      winningLotto = InputView.getLastWeekWinningLotto();
    } catch (IllegalArgumentException e) {
      System.out.println(INVALID_BONUS_MESSAGE);
      winningLotto = getLastWeekWinningLotto();
    }
    return winningLotto;
  }
}
