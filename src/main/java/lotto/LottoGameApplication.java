package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class LottoGameApplication {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();

        int price = InputView.getPrice();
        int purchaseCount = lottoGame.purchaseLotto(price);
        int manualPurchaseCount = InputView.getManualPurchaseCount();
        int autoPurchaseCount = purchaseCount - manualPurchaseCount;

        List<Lotto> manualLottos = InputView.getManualLottoNumbers(manualPurchaseCount);
        ResultView.printPurChaseCount(manualPurchaseCount, autoPurchaseCount);

        List<Lotto> lottos = lottoGame.createLottos(manualLottos, autoPurchaseCount);
        ResultView.printLottoNumbers(lottos);

        WinningLotto winningLotto = InputView.getWinningLotto();
        List<Rank> results = lottoGame.match(lottos, winningLotto);
        ResultView.printWinningStatus(results);

        double rateOfRevenue = lottoGame.getRateOfRevenue(price, lottoGame.getTotalWinnings(results));
        ResultView.printRateOfRevenue(rateOfRevenue);
    }
}
