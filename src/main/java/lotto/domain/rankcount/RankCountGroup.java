package lotto.domain.rankcount;

import lotto.domain.lotto.LotteryRank;

import java.util.Map;

public class RankCountGroup {

    private static final Long DEFAULT_COUNT = 0L;

    private final Map<LotteryRank, Long> rankCountGroup;

    public RankCountGroup(Map<LotteryRank, Long> rankCountGruop) {
        this.rankCountGroup = rankCountGruop;
    }

    public long findWinningCountBy(LotteryRank rank) {
        return rankCountGroup.getOrDefault(rank, DEFAULT_COUNT);
    }
}
