package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoStatisticComputer {

    private List<Lotto> lottos;

    public LottoStatisticComputer(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Statistics computeStatistic(Lotto winLotto, Budget budget) {
        return new Statistics(checkStatisticNumberMatch(winLotto), budget);
    }

    private List<Statistic> checkStatisticNumberMatch(Lotto winLotto) {
        return lottos.stream()
                .map(lotto -> getStatistic(winLotto, lotto))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private static Statistic getStatistic(Lotto winLotto, Lotto lotto) {
        return Statistic.valueOfMatchNumber(
                lotto.getFeatNumberCount(winLotto)
        );
    }
}
