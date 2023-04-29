package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {
  public static void main(String[] args) {
    Money purchaseAmount = InputView.getPurchaseAmount();
    LottoGame lottoGame = new LottoGame(purchaseAmount);
    OutputView.printLottoTickets(lottoGame.getLottoTickets());

    LottoNumbers winningNumbers = InputView.getLastWeekWinningNumbers();
    LottoNumber bonusNumber = InputView.getBonusNumber();
    LottoStatistics statistics = lottoGame.getStatistics(winningNumbers, bonusNumber);
    OutputView.printStatistics(statistics);
  }
}
