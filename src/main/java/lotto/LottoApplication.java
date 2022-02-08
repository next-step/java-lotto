package lotto;

import lotto.domain.LottoResult;
import lotto.domain.Lottoes;
import lotto.domain.WinningLotto;
import lotto.domain.YieldCalculator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        final int money = InputView.inputMoney();
        final int lottoCount = money / 1000;
        ResultView.printLottoCount(lottoCount);

        final Lottoes lottoes = new Lottoes(lottoCount);
        ResultView.printLottos(lottoes);

        final WinningLotto winningLotto = new WinningLotto(InputView.inputLastWinningNumbers());
        InputView.inputBonusNumber(winningLotto);

        final LottoResult lottoResult = new LottoResult();
        lottoResult.raffle(winningLotto, lottoes);

        double yield = YieldCalculator.calculateYield(lottoResult, money);
        ResultView.printLottoResults(lottoResult, yield);
    }
}
