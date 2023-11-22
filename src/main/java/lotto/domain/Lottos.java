package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public PrizeSummary getPrizeSummary(Lotto winningLotto) {
        Map<Prize, Integer> prizeSummary = initializePrizeSummary();
        countPrizes(winningLotto, prizeSummary);
        return new PrizeSummary(prizeSummary);
    }

    private Map<Prize, Integer> initializePrizeSummary() {
        Map<Prize, Integer> prizeSummary = new EnumMap<>(Prize.class);
        for (Prize prize : Prize.values()) {
            prizeSummary.put(prize, 0);
        }
        return prizeSummary;
    }

    private void countPrizes(Lotto winningLotto, Map<Prize, Integer> prizeSummary) {
        for (Lotto lotto : lottos) {
            Prize prize = lotto.determinePrize(winningLotto);
            prizeSummary.put(prize, prizeSummary.get(prize) + 1);
        }
    }
}
