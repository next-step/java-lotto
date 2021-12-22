package lotto;

import lotto.domain.Lottos;
import lotto.domain.PrizeStatistic;
import lotto.domain.PrizeType;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.math.BigDecimal;
import java.util.Arrays;

public class LottoGame {
    private LottoGame() {
        throw new AssertionError();
    }

    static void playLotto() {
        InputView inputView = new InputView();
        Lottos lottos = inputView.getLottos();
        WinningLotto winningLotto = inputView.getWinningLotto();
        PrizeStatistic prizeStat = lottos.countMatch(winningLotto);
        printResult(prizeStat, lottos.getInvestment());
    }

    private static void printResult(PrizeStatistic prizeStat, BigDecimal investment) {
        ResultView resultView = new ResultView();
        Arrays.stream(PrizeType.values())
                .filter(prizeType -> prizeType != PrizeType.MISS)
                .forEach(prizeType -> resultView.printPrize(prizeType,
                        prizeStat.getOrDefault(prizeType)));
        resultView.printProfitMargin(investment);
    }
}
