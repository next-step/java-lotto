package lotto.controller;

import lotto.domain.LottoProfit;
import lotto.domain.LottoTickets;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Set;

public class LottoController {

  private final InputView inputView;
  private final ResultView resultView;

  public LottoController(InputView inputView, ResultView resultView) {
    this.inputView = inputView;
    this.resultView = resultView;
  }

  public void purchase() {

    int inputPurchaseAmount = inputView.receivePurchaseAmount();
    int manualPurchaseCount = inputView.receiveManualPurchaseCount();
    List<Set<Integer>> manualLottoNumbers = inputView.receiveManualPurchaseLottos(manualPurchaseCount);

    PurchaseAmount purchaseAmount = PurchaseAmount.of(inputPurchaseAmount, manualPurchaseCount);
    LottoTickets lottoTickets = LottoTickets.purchaseBy(purchaseAmount, manualLottoNumbers);

    resultView.printLottoTicketCounts(lottoTickets.autoTicketCount());
    resultView.printLottoTickets(lottoTickets.getTickets());

    WinningNumbers winningNumbers = WinningNumbers.of(inputView.receiveWinningNumbers(), inputView.receiveBonusBall());
    LottoProfit lottoProfit = LottoProfit.of(winningNumbers, lottoTickets);

    resultView.printLottoProfitRate(lottoProfit);
  }
}
