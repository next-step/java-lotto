package lotto.domain.rank;

import lotto.domain.Money;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.dto.RewardCountAndPrizeMoney;
import lotto.dto.WinLotteryResult;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoRankCalculator {
    public WinLotteryResult calculate(final Lottos lottos, final Lotto winningLottery) {
        final List<RankCount> rankCounts = createRankHitCounts();
        
        for (final Lotto lotto : lottos.get()) {
            final int hitCount = lotto.countHitNumber(winningLottery);
            final boolean matchBonus = lotto.isMatchBonus(winningLottery);
            increaseHitCount(rankCounts, hitCount, matchBonus);
        }

        return toWinLotteryResult(rankCounts);
    }
    
    private List<RankCount> createRankHitCounts() {
        return Collections.unmodifiableList(
                Arrays.stream(Rank.values())
                        .map(RankCount::of)
                        .collect(Collectors.toList())
        );
    }

    public int increaseHitCount(final List<RankCount> rankCounts, final int hitCount, final boolean matchBonus) {
        final Rank rank = Rank.valueOf(hitCount, matchBonus);
        final RankCount selectedRankCount = rankCounts.stream()
                .filter(rewardCount -> rewardCount.isMatch(rank))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
        selectedRankCount.increase();
        return selectedRankCount.getCount();
    }

    public int getCount(final Rank rank, final List<RankCount> rankCounts) {
        if (rank == null) {
            return 0;
        }

        return rankCounts.stream()
                .filter(rankCount -> rankCount.isMatch(rank))
                .findAny()
                .map(RankCount::getCount)
                .orElseThrow(IllegalArgumentException::new);
    }

    public WinLotteryResult toWinLotteryResult(final List<RankCount> rankCounts) {
        return new WinLotteryResult(
                createRewardCountAndPrizeMoney(Rank.FIRST, rankCounts),
                createRewardCountAndPrizeMoney(Rank.SECOND, rankCounts),
                createRewardCountAndPrizeMoney(Rank.THIRD, rankCounts),
                createRewardCountAndPrizeMoney(Rank.FOURTH, rankCounts),
                createRewardCountAndPrizeMoney(Rank.FIFTH, rankCounts),
                calculateTotalPrizeMoney(rankCounts)
        );
    }

    private RewardCountAndPrizeMoney createRewardCountAndPrizeMoney(final Rank rank, final List<RankCount> rankCounts) {
        return new RewardCountAndPrizeMoney(rank.getCountOfMatch(), getCount(rank, rankCounts), rank.getWinningMoney());
    }

    private Money calculateTotalPrizeMoney(final List<RankCount> rankCounts) {
        return Arrays.stream(Rank.values())
                .map(reward -> {
                    final Money money = reward.getWinningMoney();
                    final int count = this.getCount(reward, rankCounts);
                    return money.multiply(count);
                })
                .reduce(Money::plus)
                .orElse(Money.ZERO);
    }
}
