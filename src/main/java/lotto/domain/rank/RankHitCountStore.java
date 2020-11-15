package lotto.domain.rank;

import lotto.domain.Money;
import lotto.dto.RewardCountAndPrizeMoney;
import lotto.dto.WinLotteryResult;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RankHitCountStore {
    private final List<RankHitCount> rankHitCounts = Arrays.stream(Rank.values()).map(RankHitCount::of).collect(Collectors.toList());

    public int increaseHitCount(final int hitCount) {
        final Rank rank = Rank.valueOf(hitCount, false);
        final RankHitCount selectedRankHitCount = rankHitCounts.stream()
                .filter(rewardCount -> rewardCount.isMatch(rank))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
        selectedRankHitCount.increase();
        return selectedRankHitCount.getCount();
    }

    public int getCount(final Rank rank) {
        if (rank == null) {
            return 0;
        }
        
        return rankHitCounts.stream()
                .filter(rankHitCount -> rankHitCount.isMatch(rank))
                .findAny()
                .map(RankHitCount::getCount)
                .orElseThrow(IllegalArgumentException::new);
    }

    public WinLotteryResult toWinLotteryResult() {
        return new WinLotteryResult(
                createRewardCountAndPrizeMoney(Rank.FIRST),
                createRewardCountAndPrizeMoney(Rank.SECOND),
                createRewardCountAndPrizeMoney(Rank.THIRD),
                createRewardCountAndPrizeMoney(Rank.FOURTH),
                createRewardCountAndPrizeMoney(Rank.FIFTH),
                calculateTotalPrizeMoney()
        );
    }

    private RewardCountAndPrizeMoney createRewardCountAndPrizeMoney(final Rank rank) {
        return new RewardCountAndPrizeMoney(rank.getCountOfMatch(), getCount(rank), rank.getWinningMoney());
    }

    private Money calculateTotalPrizeMoney() {
        return Arrays.stream(Rank.values())
                .map(reward -> {
                    final Money money = reward.getWinningMoney();
                    final int count = this.getCount(reward);
                    return money.multiply(count);
                })
                .reduce(Money::plus)
                .orElse(Money.ZERO);
    }
}
