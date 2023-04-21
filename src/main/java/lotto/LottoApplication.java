package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoTickets;
import lotto.domain.LottoVendingMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {

  public static void main(String[] args) {
    int tryRandomCount = InputView.inputTryCount();
    LottoTickets soldLottoTicket = LottoVendingMachine.issueLottoTickets(tryRandomCount);
    ResultView.showLottoTickets(soldLottoTicket);

    List<Integer> winningLottoNumbers = InputView.inputWinningTicketNumbers();
    LottoGame lottoGame = LottoVendingMachine.startGame(soldLottoTicket, winningLottoNumbers);

    ResultView.showLottoResult(LottoVendingMachine.lottoResult(lottoGame));
  }
}
