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
        for (Lotto lotto : InputView.promptForLottoNumbers(count)) {
            factories.add(() -> lotto);
        }

        Lottos lottos = new Lottos(price, factories);
        ResultView.print(lottos, factories.size());

        WinningLotto winningLotto = new WinningLotto(InputView.promptForWinningNumbers(), InputView.promptForBonusBall());
        Ranks ranks = winningLotto.ranks(lottos);
        ResultView.printRanks(ranks);
        ResultView.printRateOfReturn(ranks.rateOfReturn());
    }
}
