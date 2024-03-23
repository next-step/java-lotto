import domain.Lottos;
import domain.Ranks;
import domain.WinningLotto;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        int price = InputView.promptForPurchasePrice();
        Lottos lottos = new Lottos(price);
        ResultView.print(lottos);

        List<Integer> winningNumbers = InputView.promptForWinningNumbers();
        int bonusBall = InputView.promptForBonusBall();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusBall);
        Ranks ranks = winningLotto.ranks(lottos);
        ResultView.printRanks(ranks);
        ResultView.printRateOfReturn(ranks.rateOfReturn());
    }
}
