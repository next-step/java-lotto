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

    String bonusNumberString = InputView.readBonusNumber();
    int bonus = Integer.parseInt(bonusNumberString);
    LottoNumber bonusNumber = new LottoNumber(bonus);
    
    LottoMatchResult matchResult = lottos.matchResult(
        new WinningNumbers(winningNumbers, bonusNumber));
    ProfitRate profitRate = new ProfitRate(matchResult.totalPrize(), amount);

    ResultView.printLottoResult(matchResult, profitRate);
  }
}
