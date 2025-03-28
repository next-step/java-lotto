package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoChecker;
import lotto.domain.RandomDrawingStrategy;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

  private static final int LOTTO_PRICE = 1_000;

  public static void main(String[] args) {

    int purchaseAmount = InputView.getPurchaseAmount();
    int ticketCount = purchaseAmount / LOTTO_PRICE;

    List<Lotto> lottos = new ArrayList<>();

    for (int i = 0; i < ticketCount; i++) {
      lottos.add(new Lotto(new RandomDrawingStrategy()));
    }

    ResultView.showLottos(lottos);

    WinningLotto winningLotto = InputView.getWinningNumbers();
    LottoChecker lottoChecker = new LottoChecker()
        .calculateResults(lottos, winningLotto, purchaseAmount);

    ResultView.printResults(lottoChecker);

  }
}
