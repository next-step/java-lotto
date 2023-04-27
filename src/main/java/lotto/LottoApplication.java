package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoTickets;
import lotto.domain.LottoVendingMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {

  public static void main(String[] args) {
    int tryTotalCount = InputView.inputTryCount();
    int tryDirectInputCount = InputView.inputDirectTryCount(tryTotalCount);

    List<List<Integer>> directInputLottoNumbers = InputView.inputDirectLottoNumbers(tryDirectInputCount, tryTotalCount);

    LottoTickets soldLottoTicket = LottoVendingMachine.issueLottoTickets(tryTotalCount, directInputLottoNumbers);
    ResultView.showLottoTickets(soldLottoTicket);

    List<Integer> winningLottoNumbers = InputView.inputWinningTicketNumbers();
    int bonusNumber = InputView.inputBonusNumber();
    LottoGame lottoGame = LottoVendingMachine.startGame(soldLottoTicket, winningLottoNumbers, bonusNumber);

    ResultView.showLottoResult(LottoVendingMachine.lottoResult(lottoGame));
  }
}
