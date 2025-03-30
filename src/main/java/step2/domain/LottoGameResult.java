package step2.domain;

import step2.domain.rank.Rank;
import step2.domain.rank.RankCounter;

import java.util.List;

public class LottoGameResult {
    private final List<Rank> ranks;

    public LottoGameResult(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public RankCounter getRankCounters() {
        RankCounter rankCounters = new RankCounter();
        for (Rank rank : ranks) {
            rankCounters.increaseCount(rank);
        }
        return rankCounters;
    }

    public Integer lottoCount() {
        return ranks.size();
    }

    public long getWinningsSum() {
        long sum = 0;
        RankCounter rankCounters = getRankCounters();
        for (Rank rank : Rank.validValues()) {
            sum += rank.getTotalWinnings(rankCounters.getCount(rank));
        }
        return sum;
    }
}
