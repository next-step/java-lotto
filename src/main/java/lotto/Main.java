package lotto;

import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import lotto.domain.view.InputView;
import lotto.domain.view.ResultView;

public class Main {
  public static void main(String[] args) {
    InputView inputView = new InputView();

    int purchaseAmount = inputView.getPurchaseAmount();

    Lotto lotto = new Lotto(purchaseAmount / 1000);
    ResultView.printBuying(lotto.getLottoGames());
    Set<Integer> lastWinningNumbers = inputView.getLastWinningNumbers();
    int bonusBall = inputView.getBonusBall();

    List<Rank> ranks = lotto.getRanks(new WinningNumbers(lastWinningNumbers, bonusBall));
    ResultView.printResult(ranks);
  }
}
