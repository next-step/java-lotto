package lotto;

import java.util.List;
import lotto.domain.LottoRaffle;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.domain.YieldCalculator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        final int money = InputView.inputMoney();
        final int lottoCount = money / 1000;
        ResultView.printLottoCount(lottoCount);

        final Lottos lottos = new Lottos(lottoCount);
        ResultView.printLottos(lottos);

        final List<Integer> winningNumbers = InputView.inputLastWinningNumbers();
        final Integer bonusNumber = InputView.inputBonusNumber(winningNumbers);

        final LottoRaffle lottoRaffle = new LottoRaffle(
            new WinningLotto(winningNumbers, bonusNumber));
        lottoRaffle.raffle(lottos);
        final LottoResult lottoResult = lottoRaffle.getResult();

        double yield = YieldCalculator.calculateYield(lottoResult, money);
        ResultView.printLottoResults(lottoResult, yield);
    }
}
