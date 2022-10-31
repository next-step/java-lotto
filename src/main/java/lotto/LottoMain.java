package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoWinningStatistics;
import lotto.domain.Lottos;
import lotto.domain.WinningLottoNumbers;
import lotto.factory.LottoFactory;
import lotto.strategy.LottoNumbersRandomStrategy;
import lotto.strategy.LottoNumbersStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        LottoNumbersStrategy strategy = new LottoNumbersRandomStrategy();

        int lottoPurchaseAmount = InputView.inputLottoPurchaseAmount();
        int manualPurchaseLottoCount = InputView.inputManualPurchaseLottoCount();
        List<LottoNumbers> lottoNumbersList =
                InputView.inputManualPurchaseLottoNumbersList(manualPurchaseLottoCount);
        Lottos manualLottos = LottoFactory.createLottos(lottoNumbersList);

        int autoPurchaseLottoCount = lottoPurchaseAmount / LottoFactory.LOTTO_AMOUNT - manualPurchaseLottoCount;
        Lottos autoLottos = LottoFactory.createLottos(strategy, autoPurchaseLottoCount);

        Lottos unionLottos = Lottos.union(manualLottos, autoLottos);

        ResultView.printLottoAmountAndNumbers(manualPurchaseLottoCount, autoPurchaseLottoCount, unionLottos);

        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(
                InputView.inputWinningLottoNumbers(), InputView.inputBonusLottoNumber());

        LottoWinningStatistics lottoWinningStatistics =
                unionLottos.giveOutWinningStatistics(lottoPurchaseAmount, winningLottoNumbers);
        ResultView.printLottoWinningStatistics(lottoWinningStatistics);
    }
}
