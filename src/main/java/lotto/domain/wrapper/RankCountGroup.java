package lotto.domain.wrapper;

import lotto.domain.LotteryRank;
import lotto.domain.RankCount;

import java.util.ArrayList;
import java.util.List;

public class RankCountGroup {

    private static final long DEFAULT_COUNT = 0;

    private List<RankCount> rankCountGruop = new ArrayList<>();

    public RankCountGroup(List<RankCount> rankCountGruop) {
        this.rankCountGruop.addAll(rankCountGruop);
    }

    public long findWinningCountBy(LotteryRank rank) {
        return rankCountGruop.stream()
            .filter(rankCount -> rankCount.isEqualWithRank(rank))
            .findFirst()
            .map(RankCount::winningCount)
            .orElse(DEFAULT_COUNT);
    }
}
