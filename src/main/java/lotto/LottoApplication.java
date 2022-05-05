package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
  public static void main(String[] args) {
    PurchaseAmount purchaseAmount = InputView.getPurchaseAmount();
    int lottoCount = purchaseAmount.getLottoCount();

    List<Lotto> manualLottos = InputView.getManualLottos(lottoCount);
    Lottos lottos = Lottos.create(manualLottos, lottoCount - manualLottos.size());
    ResultView.printLottos(lottos);

    WinningLotto lastWeekWinningLotto = InputView.getLastWeekWinningLotto();

    LottoResult result = lottos.calculate(lastWeekWinningLotto);
    ResultView.printResult(result, result.calculateYield(purchaseAmount));
  }
}
