package lotto;

import java.util.List;
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
    int manualCount = InputView.inputManualLottoCount();
    List<String> manualTickets = InputView.inputManualLottoTickets(manualCount);

    int totalCount = machine.calculateTotalCount(new Money(purchaseAmount));

    Purchase purchase = machine.createPurchase(manualCount, totalCount);
    ResultView.printPurchase(purchase);

    LottoTickets tickets = machine.generateTickets(manualTickets, purchase.getAutoCount());
    ResultView.printTickets(tickets);

    String winningLottoNumbers = InputView.inputWinningLottoNumbers();
    int bonusNumber = InputView.inputBonusNumber();
    WinningTicket winning = new WinningTicket(winningLottoNumbers, bonusNumber);

    GameResult result = tickets.match(winning);
    ResultView.printResult(result, purchase.getPurchaseAmount());
  }
}