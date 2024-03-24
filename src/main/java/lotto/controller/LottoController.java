package lotto.controller;

import lotto.domain.LottoProfit;
import lotto.domain.LottoTickets;
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
    LottoTickets lottoTickets = LottoTickets.purchaseBy(inputView.receivePurchaseAmount());
    resultView.printLottoTicketCounts(lottoTickets.ticketCount());
    resultView.printLottoTickets(lottoTickets.getTickets());

    WinningNumbers winningNumbers = WinningNumbers.of(inputView.receiveWinningNumbers(), inputView.receiveBonusBall());
    LottoProfit lottoProfit = LottoProfit.of(winningNumbers, lottoTickets);

    resultView.printLottoProfitRate(lottoProfit);
  }
}
