import domain.*;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        int price = InputView.promptForPurchasePrice();
        Lottos lottos = new Lottos(price);
        ResultView.print(lottos);

        LottoNumbers winningNumbers = InputView.promptForWinningNumbers();
        LottoNumber bonusBall = InputView.promptForBonusBall();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusBall);
        Ranks ranks = winningLotto.ranks(lottos);
        ResultView.printRanks(ranks);
        ResultView.printRateOfReturn(ranks.rateOfReturn());
    }
}
