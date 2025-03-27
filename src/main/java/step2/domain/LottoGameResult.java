package step2.domain;

import step2.domain.lotto.Rank;

import java.util.List;

public class LottoGameResult {
    private final List<Rank> ranks;

    public LottoGameResult(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public RankCounter getRankCounters() {
        RankCounter rankCounters = new RankCounter();
        for (Rank rank: ranks) {
            rankCounters.increaseCount(rank);
        }
        return rankCounters;
    }
}
