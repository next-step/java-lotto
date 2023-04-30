package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoApplication {
  public static void main(String[] args) {
    Money purchaseAmount = InputView.getPurchaseAmount();
    List<LottoTicket> manualLottoTickets = InputView.getManualLottoTickets();
    LottoGame lottoGame = LottoGame.builder(purchaseAmount)
                               .manualTickets(manualLottoTickets)
                               .build();
    OutputView.printLottoTickets(lottoGame.getLottoTickets(), manualLottoTickets.size());

    LottoNumbers winningNumbers = InputView.getLastWeekWinningNumbers();
    LottoNumber bonusNumber = InputView.getBonusNumber();
    LottoStatistics statistics = lottoGame.getStatistics(winningNumbers, bonusNumber);
    OutputView.printStatistics(statistics);
  }
}
