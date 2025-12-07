package lotto;

import java.util.List;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

  public static void main(String[] args) {

    PurchaseAmount amount = createPurchaseAmount();

    ManualLottoCount manualCount = createManualLottoCount(amount);
    Lottos manualLottos = createManualLottos(manualCount);
    Lottos autoLottos = new AutoLottosGenerator(amount.autoCount(manualCount)).generate();

    Lottos purchased = manualLottos.merge(autoLottos);
    ResultView.printPurchasedLottos(purchased, manualCount);

    WinningNumbers winningNumbers = createWinningNumbers();
    LottoMatchResult matchResult = purchased.matchResult(winningNumbers);
    ProfitRate profitRate = new ProfitRate(matchResult.totalPrize(), amount);

    ResultView.printLottoResult(matchResult, profitRate);
  }

  private static PurchaseAmount createPurchaseAmount() {
    return InputRetry.retry(() ->
        new PurchaseAmount(InputView.readPurchaseAmount())
    );
  }

  private static ManualLottoCount createManualLottoCount(PurchaseAmount amount) {
    return InputRetry.retry(() ->
        new ManualLottoCount(InputView.readManualLottoCount(), amount)
    );
  }

  private static Lottos createManualLottos(ManualLottoCount manualCount) {
    return InputRetry.retry(() -> {
      List<String> manualNumbers = InputView.readManualLottos(manualCount.count());
      LottosGenerator generator = new ManualLottosGenerator(manualNumbers);
      return generator.generate();
    });
  }

  private static WinningNumbers createWinningNumbers() {
    return InputRetry.retry(() -> {
      Lotto winning = new Lotto(InputView.readWinningNumbers());
      LottoNumber bonus = LottoNumber.of(InputView.readBonusNumber());
      return new WinningNumbers(winning, bonus);
    });
  }
}
