package lotto;

import java.util.List;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

  public static void main(String[] args) {

    int input = InputView.readPurchaseAmount();
    PurchaseAmount amount = new PurchaseAmount(input);
    List<Lotto> lottos = LottoMachine.generateLottos(amount.getTicketCount());
    ResultView.printPurchasedLottos(lottos);

    Lotto winningNumbers = InputView.readWinningNumbers();
    ResultView.printLottoResult(LottoMachine.generateResult(lottos, winningNumbers, amount));
  }

}
