package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.PrizeType;
import lotto.domain.Statistics;
import lotto.view.ResultView;

import java.util.Map;

public class LottoController {

    private static Lottos lottos;

    public static void lottoGenerator(String money) {
        lottos = new Lottos(Integer.parseInt(money));
        ResultView.printLottos(lottos);
    }

    public static void statisticsGenerator(String winnerNumber, String money) {
        Statistics statistics = new Statistics();
        ResultView.printStatistics(statistics.generator(lottos, winnerNumber));
        ResultView.printRateOfReturn(statistics.getRateOfReturn(Integer.parseInt(money)));
    }
}
