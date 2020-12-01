package lotto.view;

import lotto.domain.LottoGameResult;
import lotto.domain.Lottoes;
import lotto.view.input.InputView;
import lotto.view.result.ResultView;

public class LottoGameView {

    public static int enterLottoAmount() {
        return InputView.enterLottoAmount();
    }

    public static void printLottoNumbers(Lottoes lottoes) {
        ResultView.printLottoNumbers(lottoes);
    }

    public static void printResult(LottoGameResult lottoGameResult) {
        ResultView.printLottoGameResult(lottoGameResult.getRanks());
        ResultView.printWinningStatistics(lottoGameResult.getRateOfReturn());
    }
}
