package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.LottoVendingMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

  public static void main(String[] args) {
    int tryTotalCount = InputView.inputTryCount();
    int tryDirectInputCount = InputView.inputDirectTryCount(tryTotalCount);

    LottoTickets directInputLottoTickets = InputView.inputDirectLottoNumbers(tryDirectInputCount, tryTotalCount);

    LottoTickets soldLottoTicket = LottoVendingMachine.issueLottoTickets(tryTotalCount, directInputLottoTickets);
    ResultView.showLottoTickets(soldLottoTicket);

    LottoTicket winningLottoNumbers = InputView.inputWinningTicketNumbers();
    int bonusNumber = InputView.inputBonusNumber();
    LottoGame lottoGame = LottoVendingMachine.startGame(soldLottoTicket, winningLottoNumbers, bonusNumber);

    ResultView.showLottoResult(LottoVendingMachine.lottoResult(lottoGame));
  }
}
