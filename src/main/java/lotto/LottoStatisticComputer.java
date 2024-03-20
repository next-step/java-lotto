package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoStatisticComputer {

    private List<Lotto> lottos;

    public LottoStatisticComputer(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Statistics computeStatistic(Lotto winLotto) {
        return new Statistics(checkStatisticNumberMatch(winLotto));
    }

    private List<Statistic> checkStatisticNumberMatch(Lotto winLotto) {
        List<Statistic> statistics = new ArrayList<>();
        for (Lotto lotto : lottos) {
            statistics.add(getStatistic(winLotto, lotto));
        }
        return statistics;
    }

    private static Statistic getStatistic(Lotto winLotto, Lotto lotto) {
        return Statistic.valueOfMatchNumber(
                        lotto.getFeatNumberCount(winLotto)
                );
    }
}
