package lotto.domain;

import lotto.domain.generator.LottoGenerator;
import lotto.domain.generator.LottoGeneratorAuto;
import lotto.domain.generator.LottoGeneratorManual;
import lotto.domain.wrapper.LottoPurchase;
import lotto.ui.LottoInputActualHandler;
import lotto.ui.LottoInputHandler;
import lotto.ui.LottoOutputHandler;

import java.util.List;

public class LottoGame {
    private LottoInputHandler input = new LottoInputActualHandler();
    private LottoOutputHandler output = new LottoOutputHandler();
    private LottoGenerator generator;
    private Lottos lottos = new Lottos();

    public LottoGame() {
        this(null);
    }

    // Integration Test를 위한 input 인터페이스 주입
    public LottoGame(LottoInputHandler input) {
        if (input != null) {
            this.input = input;
        }
    }

    public LottoResultPack start() {
        LottoPurchase lottoPurchase = new LottoPurchase(input.scanLottoPurchaseBudget()
                                                        ,input.scanCountOfManualLotto());

        List<String> manualLottoStrings = input.scanManualLottos(lottoPurchase.manualCount());

        generator = new LottoGeneratorManual(manualLottoStrings);
        lottos.add(generator.generate());
        generator = new LottoGeneratorAuto(lottoPurchase.countOfAvailableAutoLotto());
        lottos.add(generator.generate());

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
