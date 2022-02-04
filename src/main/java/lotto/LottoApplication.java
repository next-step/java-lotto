package lotto;

import java.util.List;
import lotto.domain.WinningBall;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        final int purchasePrice = InputView.getPurchasePrice();
        ResultView.printLottoQuantity(purchasePrice);
        ResultView.printTotalLottoNumbers();

        List<WinningBall> winningBalls = InputView.getWinningBalls();

    }
}
