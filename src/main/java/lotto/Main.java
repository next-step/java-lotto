package lotto;

import java.util.List;
import lotto.domain.LottoGame;
import lotto.domain.LottoGames;
import lotto.domain.WinningResult;
import lotto.domain.WinningLottoGame;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {
  public static void main(String[] args) {
    InputView inputView = new InputView();

    int purchaseAmount = inputView.payMoney();
    List<LottoGame> manualGames = inputView.buyManualGames();

    LottoGames lottoGames = new LottoGames(purchaseAmount, manualGames);
    ResultView.printBuying(lottoGames.getLottoGames(), manualGames);
    WinningLottoGame winningLottoGame = inputView.askWinningLottoGame();

    WinningResult winningResult = lottoGames.confirmResult(winningLottoGame);
    ResultView.printWinningResult(winningResult);
  }
}
