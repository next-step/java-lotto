package lotto.domain.rank;

import lotto.domain.Money;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;
import lotto.dto.WinLotteryResult;

import java.util.Arrays;

public class LottoRankCalculator {
    public WinLotteryResult calculateWinLotteryResult(final LottoTickets lottoTickets, final LottoTicket winningLotto, final LottoNumber bonusNumber) {
        final RankCounts rankCounts = RankCounts.of();
        
        for (final LottoTicket lottoTicket : lottoTickets.get()) {
            final int hitCount = lottoTicket.countHitNumber(winningLotto);
            final boolean matchBonus = lottoTicket.isMatchBonus(bonusNumber);
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
