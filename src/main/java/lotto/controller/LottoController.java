package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Statistics;

import java.util.List;

public class LottoController {
    public static Lottos generateLotto(String money, List<String> manualLottoNumbers) {
        return new Lottos(Integer.parseInt(money), manualLottoNumbers);
    }

    public static Statistics generateStatistics(Lottos lottos, String winnerNumber, int bonusNumber) {
        Statistics statistics = new Statistics();
        statistics.generate(lottos, winnerNumber, bonusNumber);
        return statistics;
    }

    public static double findRateOfReturn(String money, Statistics statistics) {
        return statistics.getRateOfReturn(Integer.parseInt(money));
    }
}
