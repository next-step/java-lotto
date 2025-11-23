package lotto;

import lotto.domain.game.LottoGame;
import lotto.domain.game.LottoMachine;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.Money;
import lotto.domain.result.GameResult;
import lotto.domain.lotto.Purchase;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoGameApplication {

  public static void main(String[] args) {
    LottoMachine machine = new LottoMachine();

    int purchaseAmount = InputView.inputPurchaseAmount();
    Purchase purchase = machine.purchase(new Money(purchaseAmount));
    ResultView.printPurchase(purchase);

    String winningLottoNumbers = InputView.inputWinningLottoNumbers();
    LottoTicket winning = LottoTicket.from(winningLottoNumbers);

    LottoGame game = new LottoGame(winning);
    GameResult gameResult = game.check(purchase);

    ResultView.printResult(gameResult);
  }
}
