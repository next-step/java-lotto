package lotto.controller;

import lotto.domain.LottoProfit;
import lotto.domain.LottoTickets;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

  private final InputView inputView;
  private final ResultView resultView;

  public LottoController(InputView inputView, ResultView resultView) {
    this.inputView = inputView;
    this.resultView = resultView;
  }

  public void purchase() {
    int inputPurchaseAmount = inputView.receivePurchaseAmount();
    int manualTicketCount = inputView.receiveManualPurchaseCount();

    LottoTickets lottoTickets = LottoTickets.purchaseBy(
        PurchaseAmount.of(inputPurchaseAmount, manualTicketCount),
        inputView.receiveManualPurchaseLottos(manualTicketCount)
    );
    resultView.printLottoTicketCounts(manualTicketCount, lottoTickets.autoTicketCount());
    resultView.printLottoTickets(lottoTickets.getTickets());

    WinningNumbers winningNumbers = WinningNumbers.of(inputView.receiveWinningNumbers(), inputView.receiveBonusBall());
    resultView.printLottoProfitRate(LottoProfit.of(winningNumbers, lottoTickets));
  }
}
