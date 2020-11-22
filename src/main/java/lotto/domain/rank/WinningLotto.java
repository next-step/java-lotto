package lotto.domain.rank;

import lotto.domain.Money;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTicketGroup;
import lotto.dto.WinLotteryResult;

import java.util.Arrays;

import static util.Preconditions.checkArgument;

public class WinningLotto {
    public static final String WINNING_LOTTO_NO_BONUS_NO_MUST_BE_NOT_DUPLICATED = "winning lotto no and bonus number must be not duplicated";

    private final LottoTicket winningLottoTicket;
    private final LottoNumber bonusNumber;

    public WinningLotto(final LottoTicket winningLottoTicket, final LottoNumber bonusNumber) {
        this.winningLottoTicket = winningLottoTicket;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(final LottoTicket lottoTicket, final LottoNumber bonusNumber) {
        checkArgument(isNotDuplicate(lottoTicket, bonusNumber), WINNING_LOTTO_NO_BONUS_NO_MUST_BE_NOT_DUPLICATED);
        return new WinningLotto(lottoTicket, bonusNumber);
    }

    private static boolean isNotDuplicate(final LottoTicket lottoTicket, final LottoNumber bonusNumber) {
        return !lottoTicket.isContain(bonusNumber);
    }

    public WinLotteryResult calculateWinLotteryResult(final LottoTicketGroup lottoTicketGroup) {
        final RankCounts rankCounts = RankCounts.of();

        for (final LottoTicket lottoTicket : lottoTicketGroup.get()) {
            final int hitCount = lottoTicket.countHitNumber(this.winningLottoTicket);
            final boolean matchBonus = lottoTicket.isMatchBonus(this.bonusNumber);
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
