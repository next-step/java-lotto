package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Lottoes;
import lotto.model.Result;
import lotto.model.Winning;
import lotto.util.LottoNumbersCreator;
import lotto.view.InputView;
import lotto.view.ResultView;

import static lotto.model.Result.LOTTO_PRICE;

public class LottoController {
    public static void run() {
        int buyAmount = InputView.inputBuyAmount();
        int buyCount = calculateBuyCount(buyAmount);
        int manualBuyCount = InputView.inputManualBuyCount(buyCount);
        int autoBuyCount = calculateAutoBuyCount(buyCount, manualBuyCount);

        Lottoes manualLottoes = new Lottoes(InputView.inputManualLottoes(manualBuyCount));
        Lottoes autoLottoes = new Lottoes(autoBuyCount, new LottoNumbersCreator());
        Lottoes lottoes = new Lottoes(manualLottoes, autoLottoes);
        ResultView.printLottoes(lottoes, manualLottoes, autoLottoes);

        Lotto winningLotto = InputView.inputWinningLotto();
        Winning winning = InputView.inputWinning(winningLotto);
        Result result = new Result(lottoes, winning);

        ResultView.printStatistics(buyCount, result);
    }

    public static int calculateBuyCount(int buyAmount) {
        return buyAmount / LOTTO_PRICE;// TODO: 객체추출 buyAmount
    }

    private static int calculateAutoBuyCount(int buyCount, int manualBuyCount) {
        return buyCount - manualBuyCount;
    }
}
