package lotto;

import lotto.domain.LottoResult;
import lotto.domain.Lottoes;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.domain.YieldCalculator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        Money money = readyMoney();
        ResultView.printMoney(money);

        final Lottoes lottoes = new Lottoes(money);
        ResultView.printLottos(lottoes);

        final WinningLotto winningLotto = readyWinningLotto();
        InputView.inputBonusNumber(winningLotto);

        final LottoResult lottoResult = new LottoResult();
        lottoResult.raffle(winningLotto, lottoes);

        double yield = YieldCalculator.calculateYield(lottoResult, money);
        ResultView.printLottoResults(lottoResult, yield);
    }

    public static Money readyMoney() {
        try {
            return new Money(InputView.inputMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readyMoney();
        }
    }

    public static WinningLotto readyWinningLotto() {
        try {
            return new WinningLotto(InputView.inputLastWinningNumbers());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readyWinningLotto();
        }
    }
}
