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

        for (int i = 0; i < budget.purchasableQuantity(Price.LOTTO); i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Statistics computeStatistic(WinLotto winLotto) {
        return new Statistics(checkStatisticNumberMatch(winLotto));
    }

    private List<Statistic> checkStatisticNumberMatch(WinLotto winLotto) {
        return lottos.stream()
            .map(lotto -> getStatistic(winLotto, lotto))
            .collect(Collectors.toList());
    }

    private static Statistic getStatistic(WinLotto winLotto, Lotto lotto) {
        return Statistic.valueOfMatchNumber(
            winLotto.getFeatNumberCount(lotto),
            winLotto.isContainBonus(lotto)
        );
    }
}
