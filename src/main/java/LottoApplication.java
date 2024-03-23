import domain.*;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        int price = InputView.promptForPurchasePrice();

        int count = InputView.promptForManualPurchaseCount();
        List<LottoFactory> factories = new ArrayList<>();
        List<LottoNumbers> lottoNumbers1 = InputView.promptForLottoNumbers(count);
        for (LottoNumbers lottoNumbers : lottoNumbers1) {
            factories.add(() -> new Lotto(lottoNumbers));
        }

        Lottos lottos = new Lottos(price, factories);
        ResultView.print(lottos, factories.size());

        LottoNumbers winningNumbers = InputView.promptForWinningNumbers();
        LottoNumber bonusBall = InputView.promptForBonusBall();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusBall);
        Ranks ranks = winningLotto.ranks(lottos);
        ResultView.printRanks(ranks);
        ResultView.printRateOfReturn(ranks.rateOfReturn());
    }
}
