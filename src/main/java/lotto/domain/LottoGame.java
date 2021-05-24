package lotto.domain;

import lotto.domain.generator.LottoGenerator;
import lotto.domain.generator.LottoGeneratorAuto;
import lotto.domain.generator.LottoGeneratorManual;
import lotto.domain.wrapper.LottoPurchase;
import lotto.ui.LottoInputActualHandler;
import lotto.ui.LottoInputHandler;
import lotto.ui.LottoOutputHandler;

import java.io.IOException;
import java.util.List;

public class LottoGame {
    private LottoInputHandler input = new LottoInputActualHandler();

    // Integration Test를 위한 input 인터페이스 주입
    public LottoGame(LottoInputHandler inputHandler) {
        if (inputHandler != null) {
            this.input = inputHandler;
        }
    }

    public LottoResultPack start() throws IOException {
        LottoOutputHandler output = new LottoOutputHandler();

        LottoPurchase lottoPurchase = new LottoPurchase(input.scanLottoPurchaseBudget()
                                                        ,input.scanCountOfManualLotto());

        List<String> manualLottoStrings = input.scanManualLottos(lottoPurchase.manualCount());

        LottoGenerator manualGenerator = new LottoGeneratorManual(manualLottoStrings);
        LottoGenerator autoGenerator = new LottoGeneratorAuto(lottoPurchase.countOfAvailableAutoLotto());
        Lottos lottos = new Lottos(manualGenerator.generate(), autoGenerator.generate());

        output.printCount(manualLottoStrings.size(), lottoPurchase.countOfAvailableAutoLotto());
        output.printBought(lottos);

        LottoWinNumbers winNumbers = new LottoWinNumbers(input.scanLottoWinNumbersString()
                                                        ,input.scanLottoBonusNumber());

        LottoResultPack lottoResultPack = winNumbers.checkAllOf(lottos);

        output.printWinnerStatistics(lottoResultPack);
        output.printProfitRatio(lottoResultPack.calculateProfitRatio(lottoPurchase));

        return lottoResultPack;
    }

}
