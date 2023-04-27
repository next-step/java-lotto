package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoStatistics;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {
  public static void main(String[] args) {
    Money purchaseAmount = InputView.getPurchaseAmount();
    LottoGame lottoGame = new LottoGame(purchaseAmount);
    OutputView.printLottoTickets(lottoGame.getLottoTickets());

    LottoNumbers winningNumbers = InputView.getLastWeekWinningNumbers();
    LottoStatistics statistics = lottoGame.getStatistics(winningNumbers);
    OutputView.printStatistics(statistics);
  }
}
