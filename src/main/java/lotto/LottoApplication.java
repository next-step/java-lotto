package lotto;

import java.util.List;
import java.util.Map;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

  public static void main(String[] args) {

    int input = InputView.readPurchaseAmount();
    PurchaseAmount amount = new PurchaseAmount(input);
    Lottos lottos = LottoMachine.generateLottos(amount.getTicketCount());
    ResultView.printPurchasedLottos(lottos);

    List<Integer> numbers = InputView.readWinningNumbers();
    Lotto winningNumbers = new Lotto(numbers);
    Map<Integer, Integer> matchResult = lottos.calculateMatchCounts(winningNumbers);
    ResultView.printLottoResult(LottoMachine.generateResult(matchResult, amount));
  }

}
