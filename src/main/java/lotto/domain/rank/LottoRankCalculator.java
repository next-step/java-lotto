package lotto.domain.rank;

import lotto.domain.Money;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.dto.WinLotteryResult;

import java.util.Arrays;

public class LottoRankCalculator {
    public WinLotteryResult calculateWinLotteryResult(final Lottos lottos, final Lotto winningLottery) {
        final RankCounts rankCounts = RankCounts.of();
        
        for (final Lotto lotto : lottos.get()) {
            final int hitCount = lotto.countHitNumber(winningLottery);
            final boolean matchBonus = lotto.isMatchBonus(winningLottery);
            rankCounts.increaseCount(hitCount, matchBonus);
        }

        return toWinLotteryResult(rankCounts);
    }
    
    private WinLotteryResult toWinLotteryResult(final RankCounts rankCounts) {
        return new WinLotteryResult(
                rankCounts.toRewardCountAndPrizeMoney(Rank.FIRST),
                rankCounts.toRewardCountAndPrizeMoney(Rank.SECOND),
                rankCounts.toRewardCountAndPrizeMoney(Rank.THIRD),
                rankCounts.toRewardCountAndPrizeMoney(Rank.FOURTH),
                rankCounts.toRewardCountAndPrizeMoney(Rank.FIFTH),
                calculateTotalPrizeMoney(rankCounts)
        );
    }
    
    private Money calculateTotalPrizeMoney(final RankCounts rankCounts) {
        return Arrays.stream(Rank.values())
                .map(reward -> {
                    final Money money = reward.getWinningMoney();
                    final int count = rankCounts.getCount(reward);
                    return money.multiply(count);
                })
                .reduce(Money::plus)
                .orElse(Money.ZERO);
    }
}
