package lotto.view;

import lotto.domain.LottoGameResult;
import lotto.domain.Lottoes;
import lotto.dto.LottoGameResultDto;
import lotto.view.input.InputView;
import lotto.view.result.ResultView;

public class LottoGameView {

    public static int enterLottoAmount() {
        return InputView.enterLottoAmount();
    }

    public static void printLottoNumbers(Lottoes lottoes) {
        ResultView.printLottoNumbers(lottoes);
    }

    public static void printResult(LottoGameResultDto lottoGameResultDto) {
        LottoGameResult result = lottoGameResultDto.getResult();
        ResultView.printLottoGameResult(result);
        ResultView.printWinningStatistics(result.getRateOfReturn(lottoGameResultDto.getPurchaseAmount()));
    }
}
