package lottery.domain.winningstrategy;

import lottery.domain.Lottery;
import lottery.domain.LotteryNumber;
import lottery.domain.LotteryResult;
import lottery.dto.LotteryStatisticDto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;

public class MatchAndBonusWinningLotteryStrategy implements WinningLotteryStrategy {

    private static final int BONUS_CHECK_SCORE = 5;
    private final Lottery winningLottery;
    private final LotteryNumber bonusNumber;

    public MatchAndBonusWinningLotteryStrategy(final Lottery winningLottery, final LotteryNumber bonusNumber) {
        this.winningLottery = winningLottery;
        this.bonusNumber = bonusNumber;
    }

    @Override
    public LotteryResult getLotteryResult(final Lottery lottery) {
        return LotteryResult.getLotteryResult(getScore(lottery));
    }

    @Override
    public LotteryStatisticDto getLotteryStatisticDto(final Map<LotteryResult, Integer> lotteryResultMap, final BigDecimal earningsRate) {
        return new LotteryStatisticDto(Arrays.asList(
                LotteryResult.THREE_MATCHES,
                LotteryResult.FOUR_MATCHES,
                LotteryResult.FIVE_MATCHES,
                LotteryResult.FIVE_AND_BONUS_MATCHES,
                LotteryResult.SIX_MATCHES),
                lotteryResultMap,
                earningsRate);
    }

    private double getScore(final Lottery lottery) {
        int matchesScore = winningLottery.getMatchesCount(lottery);
        return matchesScore == BONUS_CHECK_SCORE
                ? matchesScore + lottery.getBonusMatchesScore(bonusNumber)
                : matchesScore;
    }

}
