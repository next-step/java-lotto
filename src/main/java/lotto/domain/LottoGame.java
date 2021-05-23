package lotto.domain;

import lotto.domain.wrapper.LottoPurchase;
import lotto.ui.LottoInputHandler;
import lotto.ui.LottoOutputHandler;

import java.util.List;

public class LottoGame {
    private LottoInputHandler input = new LottoInputHandler();
    private LottoOutputHandler output = new LottoOutputHandler();
    private Lottos lottos = new Lottos();

    public void start() {
        LottoPurchase lottoPurchase = new LottoPurchase(input.scanLottoPurchaseBudget()
                                                        ,input.scanCountOfManualLotto());

        List<String> manualLottoStrings = input.scanManualLottos(lottoPurchase.manualCount());

        lottos.buyManual(manualLottoStrings);
        lottos.buyAuto(lottoPurchase.countOfAvailableAutoLotto());

        output.printCount(manualLottoStrings.size(), lottoPurchase.countOfAvailableAutoLotto());
        output.printBought(lottos);

        LottoWinNumbers winNumbers = new LottoWinNumbers(input.scanLottoWinNumbersString()
                                                        ,input.scanLottoBonusNumber());

        LottoResultPack resultPack = winNumbers.checkAllOf(lottos);

        output.printWinnerStatistics(resultPack);
        output.printProfitRatio(resultPack.calculateProfitRatio(lottoPurchase));
    }

}
