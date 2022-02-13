package lotto;

import java.util.List;
import lotto.domain.LottoResults;
import lotto.domain.UserLotto;
import lotto.domain.WinningBall;
import lotto.domain.UserLottoFactory;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        final int purchasePrice = InputView.getPurchasePrice();
        final int quantity = UserLottoFactory.getLottoQuantity(purchasePrice);
        final List<UserLotto> lottos = UserLottoFactory.from(quantity);

        ResultView.printLottoQuantityAndNumbers(quantity, lottos);

        List<WinningBall> winningBalls = InputView.getWinningBalls();
        LottoResults lottoResults = new LottoResults(lottos, winningBalls);

        ResultView.printResult(lottoResults.getResults(), purchasePrice);
    }
}
