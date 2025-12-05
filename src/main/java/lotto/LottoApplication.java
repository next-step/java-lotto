package lotto;

import java.util.List;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

  public static void main(String[] args) {

    int input = InputView.readPurchaseAmount();
    PurchaseAmount amount = new PurchaseAmount(input);

    int manualCount = InputView.readManualLottoCount();
    List<String> manualInputs = InputView.readManualLottos(manualCount);
    Lottos manualLottos = Lottos.manualLottos(manualInputs);

    Lottos lottos = LottoMachine.randomLottos(amount.ticketCount() - manualCount);

    Lottos mergedLottos = manualLottos.merge(lottos);
    ResultView.printPurchasedLottos(mergedLottos, manualCount);

    Lotto winningNumbers = new Lotto(InputView.readWinningNumbers());
    LottoNumber bonusNumber = LottoNumber.of(InputView.readBonusNumber());

    LottoMatchResult matchResult = lottos.matchResult(
        new WinningNumbers(winningNumbers, bonusNumber));
    ProfitRate profitRate = new ProfitRate(matchResult.totalPrize(), amount);

    ResultView.printLottoResult(matchResult, profitRate);
  }
}
