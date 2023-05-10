package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Statistics;
import lotto.view.ResultView;

public class LottoController {
    public static Lottos generateLotto(String money) {
        Lottos lottos = new Lottos(Integer.parseInt(money));
        ResultView.printLottos(lottos);
        return lottos;
    }

    public static Statistics generateStatistics(Lottos lottos, String winnerNumber) {
        Statistics statistics = new Statistics();
        ResultView.printStatistics(statistics.generate(lottos, winnerNumber));
        return statistics;
    }

    public static void findRateOfReturn(String money, Statistics statistics) {
        ResultView.printRateOfReturn(statistics.getRateOfReturn(Integer.parseInt(money)));
    }


}
