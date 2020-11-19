package lotto.domain.rank;

import lotto.dto.RewardCountAndPrizeMoney;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RankCounts {
    final List<RankCount> rankCounts;

    private RankCounts(final List<RankCount> rankCounts) {
        this.rankCounts = rankCounts;
    }

    public static RankCounts of() {
        final List<RankCount> rankCounts = Collections.unmodifiableList(
                Arrays.stream(Rank.values())
                        .map(RankCount::of)
                        .collect(Collectors.toList())
        );
        return new RankCounts(rankCounts);
    }

    public int getCount(final Rank rank) {
        if (rank == null) {
            return 0;
        }

        return rankCounts.stream()
                .filter(rankCount -> rankCount.isMatch(rank))
                .findAny()
                .map(RankCount::getCount)
                .orElseThrow(IllegalArgumentException::new);
    }

    public int increaseCount(final int hitCount, final boolean matchBonus) {
        final Rank rank = Rank.valueOf(hitCount, matchBonus);
        final RankCount selectedRankCount = rankCounts.stream()
                .filter(rewardCount -> rewardCount.isMatch(rank))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
        selectedRankCount.increase();
        return selectedRankCount.getCount();
    }

    public RewardCountAndPrizeMoney toRewardCountAndPrizeMoney(final Rank rank) {
        return new RewardCountAndPrizeMoney(rank.getCountOfMatch(), getCount(rank), rank.getWinningMoney());
    }
}
