package lotto;

import lotto.domain.Lottos;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    Lottos lottos = Lottos.of(
        inputView.getPurchaseAmount(),
        inputView.getManualLottoTickets()
    );

    ResultView.showLottos(lottos);

    WinningResult winningResult = lottos.analyze(inputView.getWinningNumbers());

    ResultView.printResults(winningResult);

  }
}
