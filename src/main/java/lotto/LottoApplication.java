package lotto;

import lotto.policy.DefaultLottoNumberGeneratePolicy;

public class LottoApplication {
  public static void main(String[] args) {
    PurchaseAmount purchaseAmount = InputView.getPurchaseAmount();
    LottoGame lottoGame = new LottoGame(purchaseAmount, new DefaultLottoNumberGeneratePolicy());
    OutputView.printLottoTickets(lottoGame.getLottoTickets());
    LottoTicket winningNumbers = new LottoTicket(InputView.getLastWeekWinningNumbers());

    OutputView.printLottoStatistics(lottoGame.getLottoStatistics(winningNumbers));
  }
}
