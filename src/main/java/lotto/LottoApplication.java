package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningBall;
import lotto.factory.LottoFactory;
import lotto.service.LottoMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        final int purchasePrice = InputView.getPurchasePrice();
        final int quantity = LottoFactory.getLottoQuantity(purchasePrice);
        final List<Lotto> lottos = LottoFactory.from(quantity);

        ResultView.printLottoQuantityAndNumbers(quantity, lottos);

        List<WinningBall> winningBalls = InputView.getWinningBalls();
        LottoMachine.run(lottos, winningBalls);

        ResultView.printResult(LottoMachine.getResults(), purchasePrice);
    }
}
