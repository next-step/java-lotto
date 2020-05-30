package lotto;

import lotto.collections.LottoResult;
import lotto.collections.LottoTickets;
import lotto.collections.Money;
import lotto.collections.WinningNumbers;
import lotto.service.PurchaseService;
import lotto.service.WinningService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class NextStepLottoApplication {

  public static void main(String[] args) {
    Money money = InputView.inputPurchaseMoney();
    LottoTickets lottoTickets = new PurchaseService().purchase(money);
    OutputView.printNumberOfPurchasedTickets(lottoTickets);

    WinningNumbers winningNumbers = InputView.inputLastWeekWinningNumbers();
    LottoResult lottoResult = new WinningService()
        .calculateLottoMatches(lottoTickets, winningNumbers);
    OutputView.printResult(lottoResult, lottoTickets);
  }
}
