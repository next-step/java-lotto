package lotto;

import java.util.Set;
import lotto.domain.LottoGames;
import lotto.domain.WinningResult;
import lotto.domain.WinningBalls;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {
  public static void main(String[] args) {
    InputView inputView = new InputView();

    int purchaseAmount = inputView.getPurchaseAmount();

    LottoGames lottoGames = new LottoGames(purchaseAmount);
    ResultView.printBuying(lottoGames.getLottoGames());
    Set<Integer> lastWinningBalls = inputView.getLastWinningBalls();
    int bonusBall = inputView.getBonusBall();

    WinningResult ranks = lottoGames.confirmResult(new WinningBalls(lastWinningBalls, bonusBall));
    ResultView.printResult(ranks);
  }
}
