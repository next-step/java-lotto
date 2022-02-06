package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningBall;
import lotto.service.LottoMachine;
import lotto.service.LottoGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        final int purchasePrice = InputView.getPurchasePrice();
        final int quantity = LottoGenerator.getLottoQuantity(purchasePrice);
        final List<Lotto> lottoNumbers = LottoGenerator.getTotalLottoNumbers(quantity);

        ResultView.printLottoQuantityAndNumbers(quantity, lottoNumbers);

        List<WinningBall> winningBalls = InputView.getWinningBalls();
        LottoMachine.run(lottoNumbers, winningBalls);

        ResultView.printResult(LottoMachine.getResults(), purchasePrice);
    }
}
