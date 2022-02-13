package lotto;

import java.util.List;
import lotto.domain.LottoResults;
import lotto.domain.WinningBall;
import lotto.dto.UserLottoInfo;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {

        final UserLottoInfo userLottoInfo = InputView.getUserLottoInfo();
        ResultView.printUserLottoInfo(userLottoInfo);

        List<WinningBall> winningBalls = InputView.getWinningBalls();
        LottoResults lottoResults = new LottoResults(userLottoInfo, winningBalls);

        ResultView.printResult(lottoResults.getResults(), userLottoInfo.getPurchasePrice());
    }
}
