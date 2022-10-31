package lotto;

import lotto.domain.Lottos;
import lotto.domain.WinningLottoNumbers;
import lotto.factory.LottoFactory;
import lotto.strategy.LottoNumbersRandomStrategy;
import lotto.strategy.LottoNumbersStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {

    public static void main(String[] args) {
        LottoNumbersStrategy strategy = new LottoNumbersRandomStrategy();

        int lottoPurchaseAmount = InputView.inputLottoPurchaseAmount();
        Lottos lottos = LottoFactory.createLottos(strategy, lottoPurchaseAmount);

        ResultView.printLottoAmountAndNumbers(lottos);

        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(
                InputView.inputWinningLottoNumbers(), InputView.inputBonusLottoNumber());

        ResultView.printLottoWinningStatistics(lottos.giveOutWinningStatistics(lottoPurchaseAmount, winningLottoNumbers));
    }
}
