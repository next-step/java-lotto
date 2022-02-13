package lotto;

import lotto.domain.result.LottoResults;
import lotto.domain.statistics.WinningStatistics;
import lotto.domain.user.LottoInitInfo;
import lotto.domain.user.UserLottos;
import lotto.domain.winning.WinningBalls;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {

        final LottoInitInfo lottoInitInfo = InputView.getLottoInitInfo();
        final UserLottos userLottos = new UserLottos(lottoInitInfo.getQuantity());
        ResultView.printUserLottos(userLottos);

        final WinningBalls winningBalls = InputView.getWinningBalls();

        LottoResults lottoResults = new LottoResults(userLottos, winningBalls);
        WinningStatistics winningStatistics = new WinningStatistics(lottoResults,
            lottoInitInfo.getPurchasePrice());

        ResultView.printResult(winningStatistics);
    }
}
