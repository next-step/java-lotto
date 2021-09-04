package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.Money;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {

  public static void main(String[] args) {
    Money purchaseMoney = InputView.inputMoney();

    long manualLottoCnt = InputView.inputManualLottoCnt(purchaseMoney);
    List<Lotto> manualLottoList = InputView.inputManualLottoList(manualLottoCnt);

    LottoGame lottoGame = new LottoGame(purchaseMoney, manualLottoList);

    ResultView.printPurchasedLottos(lottoGame.lottos());

    WinningResult winningResult = lottoGame.winningResult(InputView.winningInfo());
    ResultView.printWinningResult(winningResult);
  }
}
