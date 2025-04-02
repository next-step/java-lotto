package step2.domain;

import step2.domain.rank.RankCounter;
import step2.domain.rank.RankType;

import java.util.List;

public class LottoGameResult {
    private final List<RankType> ranks;

    public LottoGameResult(List<RankType> ranks) {
        this.ranks = ranks;
    }

    public RankCounter getRankCounters() {
        RankCounter rankCounters = new RankCounter();
        for (RankType rank : ranks) {
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
        for (RankType rank : RankType.validValues()) {
            sum += rank.getTotalWinnings(rankCounters.getCount(rank));
        }
        return sum;
    }
}
