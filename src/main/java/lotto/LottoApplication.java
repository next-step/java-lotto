package lotto;

import lotto.domain.LottoCount;
import lotto.domain.LottoResult;
import lotto.domain.Lottoes;
import lotto.domain.WinningLotto;
import lotto.domain.YieldCalculator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        LottoCount lottoCount = new LottoCount(InputView.inputMoney());
        ResultView.printLottoCount(lottoCount);

        final Lottoes lottoes = new Lottoes(lottoCount);
        ResultView.printLottos(lottoes);

        final WinningLotto winningLotto = new WinningLotto(InputView.inputLastWinningNumbers());
        InputView.inputBonusNumber(winningLotto);

        final LottoResult lottoResult = new LottoResult();
        lottoResult.raffle(winningLotto, lottoes);

        double yield = YieldCalculator.calculateYield(lottoResult, lottoCount);
        ResultView.printLottoResults(lottoResult, yield);
    }
}
