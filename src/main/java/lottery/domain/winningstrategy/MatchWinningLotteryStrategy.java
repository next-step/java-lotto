package lottery.domain.winningstrategy;

import lottery.domain.Lottery;
import lottery.domain.LotteryResult;

import static lottery.domain.LotteryResult.getLotteryResult;

public class MatchWinningLotteryStrategy implements WinningLotteryStrategy {

    private final Lottery winningLottery;

    public MatchWinningLotteryStrategy(final Lottery winningLottery) {
        this.winningLottery = winningLottery;
    }

    @Override
    public LotteryResult getScore(final Lottery lottery) {
        return LotteryResult.getLotteryResult(winningLottery.getMatchesCount(lottery));
    }

}
