package lotto.domain;

import lotto.domain.type.Rank;

import java.util.List;

public class LottoStatistics {
    private final Profit profit;
    private final List<Rank> ranks;

    public LottoStatistics(Lottos lottos, WinningLotto winningLotto) {
        this(winningLotto.match(lottos));
    }

    public LottoStatistics(List<Rank> ranks) {
        this.ranks = ranks;
        this.profit = new Profit(ranks);
    }

    public double profit() {
        return profit.value();
    }

    public int getMatchCount(Rank type) {
        return (int) ranks.stream()
                .filter(t -> t.equals(type))
                .count();
    }
}
