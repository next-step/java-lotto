package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {

    private final Map<LottoRank, Integer> statistics
        = new EnumMap<>(LottoRank.class);

    public LottoStatistics(WinningLotto winningLotto, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            LottoRank rank = lotto.getRank(winningLotto);
            statistics.put(rank, statistics.getOrDefault(rank, 0) + 1);
        }
    }

    public Map<LottoRank, Integer> getStatistics() {
        return statistics;
    }

    public Money getTotalPrize() {
        return statistics.entrySet().stream()
            .map(entry -> entry.getKey().getPrize().mul(new Money(entry.getValue())))
            .reduce(Money.ZERO, Money::add);
    }

}
