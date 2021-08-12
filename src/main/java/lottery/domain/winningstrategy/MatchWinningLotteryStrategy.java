package lottery.domain.winningstrategy;

import lottery.domain.Lottery;
import lottery.domain.LotteryResult;
import lottery.dto.LotteryStatisticDto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;

public class MatchWinningLotteryStrategy implements WinningLotteryStrategy {

    private final Lottery winningLottery;

    public MatchWinningLotteryStrategy(final Lottery winningLottery) {
        this.winningLottery = winningLottery;
    }

    @Override
    public LotteryResult getLotteryResult(final Lottery lottery) {
        return LotteryResult.getLotteryResult(winningLottery.getMatchesCount(lottery), false);
    }

    @Override
    public LotteryStatisticDto getLotteryStatisticDto(final Map<LotteryResult, Integer> lotteryResultMap, final BigDecimal earningsRate) {
        return new LotteryStatisticDto(Arrays.asList(
                LotteryResult.THREE_MATCHES,
                LotteryResult.FOUR_MATCHES,
                LotteryResult.FIVE_MATCHES,
                LotteryResult.SIX_MATCHES),
                lotteryResultMap,
                earningsRate);
    }

}
