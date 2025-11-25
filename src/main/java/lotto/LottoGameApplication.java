package lotto;

import lotto.domain.game.LottoMachine;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.lotto.Money;
import lotto.domain.lotto.Purchase;
import lotto.domain.lotto.WinningTicket;
import lotto.domain.result.GameResult;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoGameApplication {

  public static void main(String[] args) {
    LottoMachine machine = new LottoMachine();

    int purchaseAmount = InputView.inputPurchaseAmount();
    Purchase purchase = machine.purchase(new Money(purchaseAmount));
    LottoTickets tickets = LottoMachine.generateTickets(purchase); // purchase에서 구매할 ticket수를 구해 LottoTicket을 생성해 반환
    ResultView.printPurchase(tickets);

    String winningLottoNumbers = InputView.inputWinningLottoNumbers();
    int bonusNumber = InputView.inputBonusNumber();
    WinningTicket winning = new WinningTicket(winningLottoNumbers, bonusNumber);

    GameResult result = tickets.match(winning);

    ResultView.printResult(result, purchase.getPurchaseAmount());
  }
}
