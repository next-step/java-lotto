package lotto;

import lotto.policy.DefaultLottoNumberGeneratePolicy;

public class LottoApplication {
  public static void main(String[] args) {
    PurchaseAmount purchaseAmount = InputView.getPurchaseAmount();
    LottoGame lottoGame = new LottoGame(purchaseAmount, new DefaultLottoNumberGeneratePolicy());
    OutputView.printLottoTickets(lottoGame.getLottoTickets());
    LottoTicket winningNumbers = new LottoTicket(InputView.getLastWeekWinningNumbers());

    new LottoStatistics(lottoGame, winningNumbers);

    OutputView.printLottoStatistics(lottoGame.getStatistics(winningNumbers));
    OutputView.printRateOfReturn(purchaseAmount, lottoGame);
  }
}
