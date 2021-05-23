package lotto;

import lotto.domain.*;
import lotto.domain.wrapper.LottoPurchase;
import lotto.ui.LottoInputHandler;
import lotto.ui.LottoOutputHandler;

import java.util.List;

public class MainLotto {
    static LottoInputHandler input = new LottoInputHandler();
    static LottoOutputHandler output = new LottoOutputHandler();
    static LottoGame game = new LottoGame();

    public static void main(String[] args) {
        LottoPurchase lottoPurchase = new LottoPurchase(input.scanLottoPurchaseBudget(),
                                                        input.scanCountOfManualLotto());

        List<String> manualLottoStrings = input.scanManualLottos(lottoPurchase.manualCount());

        Lottos lottos = game.buyManualLottosUsing(manualLottoStrings);
        lottos.buyAuto(lottoPurchase.countOfAvailableAutoLotto());

        output.printCount(manualLottoStrings.size(), lottoPurchase.countOfAvailableAutoLotto());
        output.printBought(lottos);

        String normalNumbers  = input.scanLottoWinNumbersString();
        int bonusNumber = input.scanLottoBonusNumber();
        LottoWinNumbers winNumbers = new LottoWinNumbers(normalNumbers, bonusNumber);

        LottoResultPack resultPack = winNumbers.checkAllOf(lottos);

        output.printWinnerStatistics(resultPack);
        output.printProfitRatio(resultPack.calculateProfitRatio(lottoPurchase));
    }

}
