package lotto;

import java.util.List;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

  public static void main(String[] args) {

    int money = InputView.readPurchaseAmount();

    List<Lotto> lottos = LottoMachine.generateLottos(money);
    ResultView.printPurchasedLottos(lottos);

    Lotto winningNumbers = InputView.readWinningNumbers();
    ResultView.printLottoResult(LottoMachine.generateResult(lottos, winningNumbers, money));
  }

}
