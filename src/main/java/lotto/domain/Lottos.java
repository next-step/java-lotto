package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public PrizeSummary getPrizeSummary(Lotto winningLotto, LottoNumber bonusBall) {
        Map<Rank, Integer> prizeSummary = initializePrizeSummary();
        countPrizes(winningLotto, bonusBall, prizeSummary);
        return new PrizeSummary(prizeSummary);
    }

    private Map<Rank, Integer> initializePrizeSummary() {
        Map<Rank, Integer> prizeSummary = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            prizeSummary.put(rank, 0);
        }
        return prizeSummary;
    }

    private void countPrizes(Lotto winningLotto, LottoNumber bonusBall, Map<Rank, Integer> prizeSummary) {
        for (Lotto lotto : lottos) {
            Rank rank = lotto.determinePrize(winningLotto, bonusBall);
            prizeSummary.put(rank, prizeSummary.get(rank) + 1);
        }
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
