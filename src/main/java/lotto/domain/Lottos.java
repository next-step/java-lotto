package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(Budget budget) {
        this(generateLottosBy(budget));
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private static List<Lotto> generateLottosBy(Budget budget) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < budget.canBuyQuantity(); i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Statistics computeStatistic(Lotto winLotto) {
        return new Statistics(checkStatisticNumberMatch(winLotto));
    }

    private List<Statistic> checkStatisticNumberMatch(Lotto winLotto) {
        return lottos.stream()
                .map(lotto -> getStatistic(winLotto, lotto))
                .collect(Collectors.toList());
    }

    private static Statistic getStatistic(Lotto winLotto, Lotto lotto) {
        return Statistic.valueOfMatchNumber(
                lotto.getFeatNumberCount(winLotto)
        );
    }
}
