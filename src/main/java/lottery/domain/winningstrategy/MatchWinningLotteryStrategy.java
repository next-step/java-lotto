package lottery.domain.winningstrategy;

import lottery.domain.Lottery;
import lottery.domain.LotteryResult;

public class MatchWinningLotteryStrategy implements WinningLotteryStrategy {

    private final Lottery winningLottery;

    public MatchWinningLotteryStrategy(final Lottery winningLottery) {
        this.winningLottery = winningLottery;
    }

    @Override
    public LotteryResult getLotteryResult(final Lottery lottery) {
        return LotteryResult.getLotteryResult(winningLottery.getMatchesCount(lottery));
    }

}
