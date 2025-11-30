package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

  public static void main(String[] args) {

    int input = InputView.readPurchaseAmount();
    PurchaseAmount amount = new PurchaseAmount(input);

    Lottos lottos = LottoMachine.randomLottos(amount.ticketCount());
    ResultView.printPurchasedLottos(lottos);

    String numbersString = InputView.readWinningNumbers();
    Lotto winningNumbers = new Lotto(numbersString);

    LottoMatchResult matchResult = lottos.matchResult(winningNumbers);
    ProfitRate profitRate = new ProfitRate(matchResult.totalPrize(), amount);

    ResultView.printLottoResult(matchResult, profitRate);
  }
}
