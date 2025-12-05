package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

  public static void main(String[] args) {

    int input = InputView.readPurchaseAmount();
    PurchaseAmount amount = new PurchaseAmount(input);

    ManualLottoCount manualLottoCount = new ManualLottoCount(InputView.readManualLottoCount(),
        amount);
    Lottos manualLottos = Lottos.manualLottos(InputView.readManualLottos(manualLottoCount.count()));

    Lottos lottos = LottoMachine.randomLottos(amount.autoCount(manualLottoCount));

    Lottos mergedLottos = manualLottos.merge(lottos);
    ResultView.printPurchasedLottos(mergedLottos, manualLottoCount);

    Lotto winningNumbers = new Lotto(InputView.readWinningNumbers());
    LottoNumber bonusNumber = LottoNumber.of(InputView.readBonusNumber());

    LottoMatchResult matchResult = lottos.matchResult(
        new WinningNumbers(winningNumbers, bonusNumber));
    ProfitRate profitRate = new ProfitRate(matchResult.totalPrize(), amount);

    ResultView.printLottoResult(matchResult, profitRate);
  }
}
