package lotto;

import lotto.domain.Lottos;
import lotto.domain.Lotto;
import lotto.domain.PrizeType;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.math.BigDecimal;
import java.util.Map;

public class LottoGame {
    private LottoGame() {
        throw new AssertionError();
    }

    static void playLotto() {
        InputView inputView = new InputView();
        Lottos lottos = inputView.getLottos();
        Lotto prizeNumbers = inputView.getPrizeNumbers();
        Map<PrizeType, Integer> prizeStat = lottos.countMatch(prizeNumbers);
        printResult(prizeStat, lottos.getInvestment());
    }

    private static void printResult(Map<PrizeType, Integer> prizeStat, BigDecimal investment) {
        ResultView resultView = new ResultView();
        resultView.printPrize(PrizeType.FOURTH.getCountOfMatch(),
                PrizeType.FOURTH.getPrizeMoney(),
                prizeStat.getOrDefault(PrizeType.FOURTH, 0));
        resultView.printPrize(PrizeType.THIRD.getCountOfMatch(),
                PrizeType.THIRD.getPrizeMoney(),
                prizeStat.getOrDefault(PrizeType.THIRD, 0));
        resultView.printPrize(PrizeType.SECOND.getCountOfMatch(),
                PrizeType.SECOND.getPrizeMoney(),
                prizeStat.getOrDefault(PrizeType.SECOND, 0));
        resultView.printPrize(PrizeType.FIRST.getCountOfMatch(),
                PrizeType.FIRST.getPrizeMoney(),
                prizeStat.getOrDefault(PrizeType.FIRST, 0));
        resultView.printProfitMargin(investment);
    }
}
