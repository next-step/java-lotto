package lotto.controller;

import lotto.model.*;
import lotto.util.LottoNumbersCreator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public static void run() {
        BuyAmount buyAmount = InputView.inputBuyAmount();
        int buyCount = buyAmount.count();
        ManualCount manualCount = InputView.inputManualCount(buyAmount);
        int autoCount = manualCount.autoCount();

        Lottoes manualLottoes = new Lottoes(InputView.inputManualLottoes(manualCount));
        Lottoes autoLottoes = new Lottoes(autoCount, new LottoNumbersCreator());
        Lottoes lottoes = new Lottoes(manualLottoes, autoLottoes);
        ResultView.printLottoes(lottoes, manualLottoes, autoLottoes);

        Lotto winningLotto = InputView.inputWinningLotto();
        Winning winning = InputView.inputWinning(winningLotto);
        Result result = new Result(lottoes, winning);

        ResultView.printStatistics(buyCount, result);
    }
}
