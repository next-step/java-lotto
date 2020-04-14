package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.Rank;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class LottoGameApplication {
    public static void main(String[] args) {
        int price = InputView.getPrice();

        LottoGame lottoGame = new LottoGame();
        int purchaseCount = lottoGame.purchaseLotto(price);

        ResultView.printPurChaseCount(purchaseCount);
        List<Lotto> lottos = lottoGame.createLottos(manualLottoNumbers, purchaseCount);

        ResultView.printLottoNumbers(lottos);

        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber();
        Lotto winningLotto = new Lotto(winningNumbers);

        List<Rank> results = lottoGame.match(lottos, winningLotto, bonusNumber);

        ResultView.printWinningStatus(results);

        double rateOfRevenue = lottoGame.getRateOfRevenue(price, lottoGame.getTotalWinnings(results));

        ResultView.printRateOfRevenue(rateOfRevenue);
    }
}
