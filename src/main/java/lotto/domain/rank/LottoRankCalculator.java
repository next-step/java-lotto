package lotto.domain.rank;

import lotto.domain.Money;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTicketGroup;
import lotto.domain.lotto.WinningLotto;
import lotto.dto.WinLotteryResult;

import java.util.Arrays;

public class LottoRankCalculator {
    public WinLotteryResult calculateWinLotteryResult(final LottoTicketGroup lottoTicketGroup, final WinningLotto winningLotto) {
        final RankCounts rankCounts = RankCounts.of();
        
        for (final LottoTicket lottoTicket : lottoTicketGroup.get()) {
            final int hitCount = lottoTicket.countHitNumber(winningLotto.getLottoTicket());
            final boolean matchBonus = lottoTicket.isMatchBonus(winningLotto.getBonusNumber());
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
