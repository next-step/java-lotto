package lotto.controller;

import lotto.domain.LottoStatistics;
import lotto.domain.Lottos;
import lotto.domain.MatchNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    private static final InputView INPUT_VIEW = new InputView();
    private static final ResultView RESULT_VIEW = new ResultView();

    public static void run() {
        int purchaseAmount = INPUT_VIEW.inputPurchaseAmount();
        int lottoCount = RESULT_VIEW.lottoCount(purchaseAmount);
        RESULT_VIEW.showLottoCount(lottoCount);

        Lottos lottos = new Lottos(lottoCount);
        RESULT_VIEW.showLottoList(lottos);

        List<Integer> winningNumbers = INPUT_VIEW.inputWinningNumbers();

        MatchNumbers matchNumbers = lottos.matchNumbers(winningNumbers);
        LottoStatistics lottoStatistics = new LottoStatistics(purchaseAmount, matchNumbers);
        RESULT_VIEW.showLottoStatistics(lottoStatistics);
    }
}
